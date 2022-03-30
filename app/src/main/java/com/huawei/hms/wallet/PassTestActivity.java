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

import com.huawei.hms.wallet.apptest.R;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.huawei.hms.wallet.constant.WalletPassConstant;
import com.huawei.hms.wallet.util.JweUtil;
import com.huawei.hmf.tasks.Task;

public class PassTestActivity extends FragmentActivity {
    private static final String TAG = "TestActivity";
    public static final int SAVE_TO_ANDROID = 888;
    public static final int NO_OWNER = 20;
    public static final int HMS_VERSION_CODE = 907135001;
    private WalletPassClient walletObjectsClient;
    private String issuerId;
    private String passObject;
    private int environment = Constant.ENVIRMENT_RUSSIA_DEBUG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sec_main);
        Intent i = this.getIntent();
        passObject = i.getStringExtra("passObject");
        Log.i(TAG, "passObject" + passObject);
        issuerId = i.getStringExtra("issuerId");
        Log.i(TAG, "issuerId:" + issuerId);
        environment = Constant.getEvn(getIntent());
    }

    //add by wallet kit sdk
    public void saveToHuaWeiWallet(View view) {
        String jweStr = getJweFromAppServer(passObject);
        CreateWalletPassRequest request = CreateWalletPassRequest.getBuilder()
                .setContent(jweStr)
                .build();
        Log.i(TAG, "getWalletObjectsClient");
        walletObjectsClient = Wallet.getWalletPassClient(PassTestActivity.this);
        Task<AutoResolvableForegroundIntentResult> task = walletObjectsClient.createWalletPass(request);
        ResolveTaskHelper.excuteTask(task, PassTestActivity.this, SAVE_TO_ANDROID);
    }

    public void clickLinkToPay(View view) {
        String jweStr = getJweFromAppServer(passObject);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("hms://www.huawei.com/payapp/{" + jweStr + "}"));
        intent.putExtra("link_kit_name", "walletkit");
        try {
            startActivityForResult(intent, SAVE_TO_ANDROID);
        } catch (ActivityNotFoundException e) {
            Log.i( TAG, "HMS error:ActivityNotFoundException");
        }
    }

    //add by wallet app or browser
    public void clickAppOrUriToPay(View view) {
        String jweStr = getJweFromAppServer(passObject);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getBrowserUrl(environment)+"/pass/save?jwt=" + Uri.encode(jweStr)));
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Log.i( TAG, "HMS error:ActivityNotFoundException");
        }
    }

    public void viewCard(View view) {
        Intent ii = PassTestActivity.this.getIntent();
        String instanceId = ii.getStringExtra("passId");
        issuerId = ii.getStringExtra("issuerId");
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getBrowserUrl(environment)+"/pass/instance?issuerId=" + issuerId + "&instanceId=" + instanceId));
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Log.i(TAG, "HMS error:ActivityNotFoundException");
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i(TAG,"requestCode："+requestCode+"resultCode"+resultCode);
        switch (requestCode) {
            case SAVE_TO_ANDROID:
                switch (resultCode) {
                    case Activity.RESULT_OK:
                        Toast.makeText(this, "save success", Toast.LENGTH_LONG).show();
                        break;
                    case Activity.RESULT_CANCELED:
                        Toast.makeText(this, "(Reason, 1：cancel by user 2：HMS not install or register or updated)", Toast.LENGTH_LONG).show();
                        break;
                    case NO_OWNER:
                        Toast.makeText(this, "Non-owner user add card error", Toast.LENGTH_LONG).show();
                        break;
                    case HMS_VERSION_CODE:
                        Toast.makeText(this, "Hms is error or updated", Toast.LENGTH_LONG).show();
                        break;
                    default:
                        if (data != null) {
                            int errorCode =
                                    data.getIntExtra(
                                            WalletPassConstant.EXTRA_ERROR_CODE, -1);
                            Log.i(TAG,"errorCode："+errorCode);
                            Toast.makeText(this, "fail, [" + errorCode + "]：" + analyzeErrorCode(errorCode), Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(this, "fail ：data is null ", Toast.LENGTH_LONG).show();
                        }
                        break;
                }
                break;
            default:
                break;
        }
    }

    private String analyzeErrorCode(int errorCode) {
        String tips = "";
        switch (errorCode) {
            case WalletPassConstant.ERROR_CODE_SERVICE_UNAVAILABLE:
                tips = "server unavailable（net error）";
                break;
            case WalletPassConstant.ERROR_CODE_INTERNAL_ERROR:
                tips = "internal error";
                break;
            case WalletPassConstant.ERROR_CODE_INVALID_PARAMETERS:
                tips = "invalid parameters or card is added";
                break;
            case WalletPassConstant.ERROR_CODE_MERCHANT_ACCOUNT_ERROR:
                tips = "JWE verify fail";
                break;
            case WalletPassConstant.ERROR_CODE_USER_ACCOUNT_ERROR:
                tips = "hms account error（invalidity or Authentication failed）";
                break;
            case WalletPassConstant.ERROR_CODE_UNSUPPORTED_API_REQUEST:
                tips = "unSupport API";
                break;
            case WalletPassConstant.ERROR_CODE_OTHERS:
            default:
                tips = "unknown Error";
                break;
        }
        return tips;
    }

    /**
     * in this demo,method getJweFromAppServer just simulate how to get jwe form passObject
     * in product environment,
     * issuerId, privateKye and SessionPublicKey is saved on the developer's Server
     * developer should send passObject to developer's Server(pls use Https)
     * Server should generateJwe by passObject ,and send back jwe to app
     *
     * @param passObject passObject
     * @return JWE
     */
    private String getJweFromAppServer(String passObject) {
        String jweStr = "";
        try {
            jweStr = JweUtil.generateJwe(issuerId, passObject, environment);
        } catch (Exception e) {
            Toast.makeText(this, "fail ：jwe trans error", Toast.LENGTH_LONG).show();
            Log.i(TAG, "jwe trans error");
            return null;
        }
        Log.i(TAG, "jweStr:" + jweStr);
        return jweStr;
    }

    /**
     * Get browser plus card domain name according to selected environment settings
     *
     * @param environment Environmental index
     */
    private String getBrowserUrl(int environment) {
        String browserUrl="";
        switch (environment) {
            case Constant.ENVIRMENT_EUROPE_RELEASE:
                browserUrl="https://walletpass-dre.cloud.huawei.com/walletkit/consumer";
                break;
            case Constant.ENVIRMENT_AFIRA_RELEASE:
                browserUrl="https://walletpass-dra.cloud.huawei.com/walletkit/consumer";
                break;
            case Constant.ENVIRMENT_RUSSIA_RELEASE:
                browserUrl="https://walletpass-drru.cloud.huawei.com/walletkit/consumer";
                break;
            case Constant.ENVIRMENT_RUSSIA_DEBUG:
                browserUrl="https://walletkit-cstr.hwcloudtest.cn:8080/walletkit/consumer";
                break;
            default:
                break;
        }
        return browserUrl;
    }
}