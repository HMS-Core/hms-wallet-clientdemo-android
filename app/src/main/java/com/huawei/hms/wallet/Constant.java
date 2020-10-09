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
    private static final String PRIVATE_KEY_RUSSIA_RELEASE = "MIIJQgIBADANBgkqhkiG9w0BAQEFAASCCSwwggkoAgEAAoICAQCdO8oMKgBcj/qJjT6SzokW7AUJ9k3FUeh2I9ZCeO7+xZ7BZ2pxFZ3fZ+rI+WSoS4KMMHvUU3Bi2Va8/64iXxzJCp3HlaZNVtnGuGfRkcWacfA2+TYTguyIA8AcsPn5xL+L8JOXDU9axTD6sOs0KKqKvxPtSdwN2QbgTI4ucQVthDQ2bxZKk/5CRENGut5LGebfDa6VKlOSjAVcIobWUhE9HaVc4YPErBSxTfA6Mq5E+EcamHkXfDjzBXI6LBpf7dBlxdL6696/42nvaXiQXkdwJ3r1PBOUjk51G19Fnyl/b6RwN0iw8T06DU96DqBInFsLFoZUCj9gE356wGqwbNkjFR3mC3b1Gni6aK9iSXqOqZ+jEzO/LTyjKqKpykR541i48+AznPAAenaQ0MIIAIedYttZVJ95mxDiuCEci6pccJ0KN16OOZx7LKyrNWBn5oDKyGG3ERRl5huaOsGhrqYkw+DUcOUTMVtfzUVCP1Jvhw7z+hqLNGkSGrt7a5CvInA2tkVHi11Vc4D+1fQDv83Uvnr8hLuGYVF/8Nn57utklH6w4rIuITgY5HnN2n1xzy+dK4/TdRF/wBC+LLpT0QxoNJADuoPOt3r0ZUSPt8lqn/9sYvqoXX5Czt55EfuZRUb9J8TEsD2JKqtQJjx4v2udbsPv0QfSwpAaS03nA0kLfwIDAQABAoICACt9URpiN61iiYqoTalvhQ2ZBJ/Hx6UPTbv3l5jVOE2xvYKDJzbWIs+bP56NFKFUGWzLMET/OzOsJ8io87JAGock75U3uELmBeBoOxcFOeHJKAcckS9+ZAwO9YE6FjpWiCCdz0TVgqB5sF12t+e6Y8lypoFYj4wo/jTmF+GSk0zCZ2qy+ThxjL8pgG4826VsKaaCc0qA5ZLANe9RAXigRHJiE84H9llcu3B7PTnrsLYU8h3SFJRBYMMfO4QJlNX5wk2UFRIgUYFD1pZI1vcfjKTh1qmkD0pkviC4DHcGWgUMjTAYqnt+jk/TRKtfBkhvLuN3PHpcR0E8wxwSwq+/u6L+l6xtxsRB5o76EKijmiPFO+UdlpdKgZq5yrAnL/yOwAaIGrTg46kU8G3ejcPC5LrpKOQpkZ7AucuYhm57gOtnu/v27/9Ruem+KJZgcWqWkYCy/d0XGfj33hnD8bfzSn6oSFoFYsihHDxyLJnw2eIULJQwM8nd7XiIKWeWFi6vTBLZzoyVoiFb7bfQYXOIqrtfhbyfxLaRiDv+K+wtmZYxslhsiZaJW89sA/gWzOwJxxFYW7gzk+YL8Oia+MAgCvVzVGU2JL8nTYEkmMJM0s/HWRLZB5IKtpEr2rhVo7lYaEZcqg5IafB7idiyviZtHFk6UiS7xDNe4ohq8kgtyejRAoIBAQDxpwjVOGWy1Iwj1ER7w6eAne7OdI40TThkFPxZsbcu1gctEO8J30WYZnJM9F/g6G2YUwo63R/bNkryq8ZXAgf/C6GIbvALeCK4QlVg/dcwnqxpDOePrc2NH5VnQYr***************************************************************************************************************************";
    //Russian test environment private key
    private static final String PRIVATE_KEY_RUSSIA_DEBUG = "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";
    //European production environment private key
    private static final String PRIVATE_KEY_EUROPE_RELEASE = "MIIJQgIBADANBgkqhkiG9w0BAQEFAASCCSwwggkoAgEAAoICAQDAqLknKCjeFx1kOgobf0IrKqwtL6DEC0a3SaPmKwiIZ4rRqVKBcef8YgdB7EOgRgut39i4OPeg9dNRKqfzUtVhAwLwRLv11+RGEWiYBNDr4mA4uRsbFqSxEXN3vE/kFrxFc6tBupBidTUAbaRb5pUrTlWuSWF4kWAdth2uAeBRU8Nl0CzmV0pI4MhFomhlyJY7gFZPlL2nGkR58AKYRaeF7Lc0HpuZs3448eUO4itveAqh/RBVseQAJSyA3RMRTWhDcYqK0BAQAwELBDQUxRh2QyyvYBJGaPPdzymEf2GsF3e+ZuVUYYxb24Uu3G9upUBMIsmzNZGoRVTPrkyFzbMiKtgg1sZQ6DmSI10lFBei1qhhWoD90f3d+qUYRgYAP4PEyuEfgANQhWgYygeh+JKK+R3xxBlez/yAwYI/ojrzjT8m9Q5S3RCBSpuIJsbOYM3512AVS9Utjvuz28uRvU6+P7NIZN+ZXOwrkPAKt77dhua4ugyqcFJSF3L7m4998kkAy9EHd3GkVWtnegl6eZu4J8JylhkRZSnP5dZ4jbZMU8YyqkelA9iE8lGXswYErpg3aCJJbu1KxLXcYFeGZPUnCyjBm3udnD+f+MvZINclilDAL3LqqQmFQd9upyiuTfKa1qVJd8bzme/EHf1UgOOSzloa7j6zPp9i/xDG/URyTwIDAQABAoICAQCFeuB9LqfR57XnYQbrsinH+pK748nAygc+qfiyWZJZ31Mgm+2b3a1bARgCJo1cF+uzlelzCZUXofm8vI8MWJGZ2xpIGXcYh3GS0jDjUkLlizwbULRk+jU0sOCNTp0TbGUYwWEf8wBiFs6X817yhTlIfceDLzgm7qHnM+wwSQB/mEdC3Q6esE+5WnOnOzSVgHoF0475KBaWFe7nhNBna6r7cNwlcidgQCntjjqjKzPo0QSc4tZUaSGMsDS7O3Aghr78K0hPkIPwdARe+5SR51Rha30kLK28tq5vOT6MnCyxrLi75FJzOfqjEd6ebv+Na1S260tPrIe0TATMtvgxpCi9BrlDV+z1F+sXrSPK0/p+8FcHCUKyo92CR2FLYMwNFQSLH4xRGeFZehO6WTXsIpob5I2xU7x2pHyi99/lUgGhzMVeNu7fkjHuQg83Iwxd1gB5ZICUvfwszN+5Np0pGJfWY/cgjfcqMgemYnOFj0xHk7ONg+ReermqFRC+h5K/8kLhReLc+u9QMIkQB24vL9oR5utA9r4QgPnvMJk5fY++zIvZ4rMToIpKz0aRgxAp/Qi9O91+fjbACRE+Zi6Rb7QECRQtSKfwNDVUuDPNtaEzaQ68qYiL46QlpCDxbyou8QoVmN4YjF8tCNddP0h92wXcVDnI5JfbOnmoRbpvbeu9EQKCAQEA/yjJs+UrcQxfUtZQ2xpq6iCvTx9LEZyGAyZcoh0uFUPLKse5JHbD3v7orZt0Is1JxwPX+qUpXpx7V6ndoqQY4kJT8tWuRrmY8ANg5j+mTL+WSfcmxsQV1FN5Bve***************************************************************************************************************************";
    //European test environment private key
    private static final String PRIVATE_KEY_EUROPE_DEBUG = "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";
    //Afro-Asian Production Environment Private Key
    static final String PRIVATE_KEY_AFIRA_RELEASE = "MIIJQgIBADANBgkqhkiG9w0BAQEFAASCCSwwggkoAgEAAoICAQCdO8oMKgBcj/qJjT6SzokW7AUJ9k3FUeh2I9ZCeO7+xZ7BZ2pxFZ3fZ+rI+WSoS4KMMHvUU3Bi2Va8/64iXxzJCp3HlaZNVtnGuGfRkcWacfA2+TYTguyIA8AcsPn5xL+L8JOXDU9axTD6sOs0KKqKvxPtSdwN2QbgTI4ucQVthDQ2bxZKk/5CRENGut5LGebfDa6VKlOSjAVcIobWUhE9HaVc4YPErBSxTfA6Mq5E+EcamHkXfDjzBXI6LBpf7dBlxdL6696/42nvaXiQXkdwJ3r1PBOUjk51G19Fnyl/b6RwN0iw8T06DU96DqBInFsLFoZUCj9gE356wGqwbNkjFR3mC3b1Gni6aK9iSXqOqZ+jEzO/LTyjKqKpykR541i48+AznPAAenaQ0MIIAIedYttZVJ95mxDiuCEci6pccJ0KN16OOZx7LKyrNWBn5oDKyGG3ERRl5huaOsGhrqYkw+DUcOUTMVtfzUVCP1Jvhw7z+hqLNGkSGrt7a5CvInA2tkVHi11Vc4D+1fQDv83Uvnr8hLuGYVF/8Nn57utklH6w4rIuITgY5HnN2n1xzy+dK4/TdRF/wBC+LLpT0QxoNJADuoPOt3r0ZUSPt8lqn/9sYvqoXX5Czt55EfuZRUb9J8TEsD2JKqtQJjx4v2udbsPv0QfSwpAaS03nA0kLfwIDAQABAoICACt9URpiN61iiYqoTalvhQ2ZBJ/Hx6UPTbv3l5jVOE2xvYKDJzbWIs+bP56NFKFUGWzLMET/OzOsJ8io87JAGock75U3uELmBeBoOxcFOeHJKAcckS9+ZAwO9YE6FjpWiCCdz0TVgqB5sF12t+e6Y8lypoFYj4wo/jTmF+GSk0zCZ2qy+ThxjL8pgG4826VsKaaCc0qA5ZLANe9RAXigRHJiE84H9llcu3B7PTnrsLYU8h3SFJRBYMMfO4QJlNX5wk2UFRIgUYFD1pZI1vcfjKTh1qmkD0pkviC4DHcGWgUMjTAYqnt+jk/TRKtfBkhvLuN3PHpcR0E8wxwSwq+/u6L+l6xtxsRB5o76EKijmiPFO+UdlpdKgZq5yrAnL/yOwAaIGrTg46kU8G3ejcPC5LrpKOQpkZ7AucuYhm57gOtnu/v27/9Ruem+KJZgcWqWkYCy/d0XGfj33hnD8bfzSn6oSFoFYsihHDxyLJnw2eIULJQwM8nd7XiIKWeWFi6vTBLZzoyVoiFb7bfQYXOIqrtfhbyfxLaRiDv+K+wtmZYxslhsiZaJW89sA/gWzOwJxxFYW7gzk+YL8Oia+MAgCvVzVGU2JL8nTYEkmMJM0s/HWRLZB5IKtpEr2rhVo7lYaEZcqg5IafB7idiyviZtHFk6UiS7xDNe4ohq8kgtyejRAoIBAQDxpwjVOGWy1Iwj1ER7w6eAne7OdI40TThkFPxZsbcu1gctEO8J30WYZnJM9F/g6G2YUwo63R/bNkryq8ZXAgf/C6GIbvALeCK4QlVg/dcwnqxpDOePrc2NH5VnQYrS***************************************************************************************************************************";
    //Asian-African test environment private key
    private static final String PRIVATE_KEY_AFIRA_DEBUG = "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";




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
