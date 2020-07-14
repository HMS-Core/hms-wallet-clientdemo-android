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

import java.util.HashMap;
import java.util.Map;

import android.content.Intent;
import android.util.Log;


public class Constant {
    //tag
    public static final String EVN_TAG = "environment";
    //Russian test environment
    public static final int ENVIRMENT_RUSSIA_DEBUG = 0;
    //Russian live network environment
    public static final int ENVIRMENT_RUSSIA_RELEASE = 1;
    //European test environment
    public static final int ENVIRMENT_EUROPE_DEBUG = 2;
    //European live network environment
    public static final int ENVIRMENT_EUROPE_RELEASE = 3;
    //Afro-Asian test environment
    public static final int ENVIRMENT_AFIRA_DEBUG = 4;
    //Asia-Africa Network
    public static final int ENVIRMENT_AFIRA_RELEASE = 5;


    //The private key is the private key obtained when the developer alliance registered the application
    //Russian production environment private key
    private static final String PRIVATE_KEY_RUSSIA_RELEASE = "Please get the private key on AGC and place it here";
    //Russian test environment private key
    private static final String PRIVATE_KEY_RUSSIA_DEBUG = "Please get the private key on AGC and place it here";
    //European production environment private key
    private static final String PRIVATE_KEY_EUROPE_RELEASE = "Please get the private key on AGC and place it here";
    //European test environment private key
    private static final String PRIVATE_KEY_EUROPE_DEBUG = "Please get the private key on AGC and place it here";
    //Afro-Asian Production Environment Private Key
    static final String PRIVATE_KEY_AFIRA_RELEASE = "Please get the private key on AGC and place it here";
    //Asian-African test environment private key
    private static final String PRIVATE_KEY_AFIRA_DEBUG = "Please get the private key on AGC and place it here";



    private static final Map<Integer, String > mKeyMap = new HashMap(){{
        put(ENVIRMENT_RUSSIA_DEBUG, PRIVATE_KEY_RUSSIA_DEBUG);
        put(ENVIRMENT_RUSSIA_RELEASE, PRIVATE_KEY_RUSSIA_RELEASE);
        put(ENVIRMENT_EUROPE_DEBUG, PRIVATE_KEY_EUROPE_DEBUG);
        put(ENVIRMENT_EUROPE_RELEASE, PRIVATE_KEY_EUROPE_RELEASE);
        put(ENVIRMENT_AFIRA_DEBUG,PRIVATE_KEY_AFIRA_DEBUG);
        put(ENVIRMENT_AFIRA_RELEASE,PRIVATE_KEY_AFIRA_RELEASE);
    }};



    //SESSION_KEY public key, used to encrypt the payload, regardless of region and environment
    public static final String SESSION_KEY_PUBLIC =  "MIIBojANBgkqhkiG9w0BAQEFAAOCAY8AMIIBigKCAYEAgBJB4usbO33Xg5vhJqfHJsMZj44f7rxpjRuPhGy37bUBjSLXN+dS6HpxnZwSVJCtmiydjl3Inq3Mzu4SCGxfb9RIjqRRfHA7ab5p3JnJVQfTEHMHy8XcABl6EPYIJMh26kztPOKU2Mkn6yhRaCurhVUD3n9bD8omiNrR4rg442AJlNamA7vgKs65AoqBuU4NBkGHg0VWWpEHCUx/xyX6hIwqc1aD7P2f62ZHsKpNZBOek/riWhaVx3dTAa9ZS+Av3IGLOZiplhYIow9f8dlWyqs8nff9FZoJO03QhXLvOORT+lPAkW6gFzaoeMaGb40HakkZn3uvlAEKrKrtR0rZEok+N1hnboaAu8oaKK0rF1W6iNrXcFrO0rcrCsFTVF8qCa/1dFmIXwUd2M6cUzT9W0YkNyb6ZBbwEhjwBL4DNW4JfeF2Dzj0eZYlSuYV7e7e1e+XEO8lwPLAiy4bEFAWCaeuDVIhbIoBaU6xHNVQoyzct98gaOYxE4mVDqAUVmhfAgMBAAE=";

    //RAS encrypted padding mode
    public static final String RAS_MODEL = "RSA/NONE/OAEPwithSHA-256andMGF1Padding";

    public static final int getEvn(Intent intent){
        int evn = ENVIRMENT_RUSSIA_DEBUG;
        try {
            evn =  intent.getIntExtra(EVN_TAG,ENVIRMENT_RUSSIA_DEBUG);
        }catch (NullPointerException e){
            Log.e(Constant.class.getSimpleName(), e.getMessage());
        }
        return evn;
    }

    public static final String getPrivateKey(int evn){
        return mKeyMap.get(evn);
    }
}
