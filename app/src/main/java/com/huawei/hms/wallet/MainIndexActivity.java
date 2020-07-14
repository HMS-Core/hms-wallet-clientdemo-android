/*
 * Copyright 2020. Huawei Technologies Co., Ltd. All rights reserved.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

package com.huawei.hms.wallet;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.wallet.apptest.R;


/**
 * demo main page
 */
public class MainIndexActivity extends FragmentActivity implements HuaweiApiClient.OnConnectionFailedListener {
    private static final String TAG = "MainIndex";
    private Spinner spinnerPoints;
    private List<String> pointsTypelist;
    private ArrayAdapter<String> pointsAdapter;
    private int environment = Constant.ENVIRMENT_RUSSIA_DEBUG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index_main);

        spinnerPoints = findViewById(R.id.spinnerPoints);
        pointsTypelist = new ArrayList<String>();
        pointsTypelist.add("Russian test environment");
        pointsTypelist.add("Russian production environment");
        pointsTypelist.add("European test environment");
        pointsTypelist.add("European production environment");
        pointsTypelist.add("Afro-Asian test environment");
        pointsTypelist.add("Afro-Asian Production Environment");
        pointsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, pointsTypelist);
        pointsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPoints.setAdapter(pointsAdapter);
        spinnerPoints.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                            int arg2, long arg3) {
                environment = arg2;
            }

            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Log.w(TAG, "onConnectionFailed: " + connectionResult);
    }

    public void saveLoyaltyCard(View view) {
        Intent intent = new Intent(this, PassDataObjectActivity.class);
        intent.putExtra(Constant.EVN_TAG, environment);
        startActivity(intent);
    }

    public void saveGiftCard(View view) {
        Intent intent = new Intent(this, GiftCardActivity.class);
        intent.putExtra(Constant.EVN_TAG, environment);
        startActivity(intent);
    }

    public void saveCouponCard(View view) {
        Intent intent = new Intent(this, CouponCardActivity.class);
        intent.putExtra(Constant.EVN_TAG, environment);
        startActivity(intent);
    }

}
