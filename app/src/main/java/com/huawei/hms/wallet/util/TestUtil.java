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

package com.huawei.hms.wallet.util;

import android.content.Context;
import android.util.Base64;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import static android.util.Base64.NO_WRAP;


public class TestUtil
{
    /**
     * Create simulation data
     */
    public static String createPassData(Context mContext)
    {
        String base64ZipData = null;
        try
        {
            InputStream inputStream = mContext.getResources().getAssets().open("common.hwpass");
            byte[] testData = InputStreamToByte(inputStream);

            base64ZipData = Base64Util.encode(testData);

        }
        catch (IOException e)
        {
            return null;
        }

        return base64ZipData;
    }

    /**
     * Get files in assets or plugins
     *
     * @return
     */
    public static byte[] InputStreamToByte(InputStream is) throws IOException
    {
        ByteArrayOutputStream bytestream = new ByteArrayOutputStream();
        int ch;
        while ((ch = is.read()) != -1)
        {
            bytestream.write(ch);
        }
        byte imgdata[] = bytestream.toByteArray();
        bytestream.close();
        return imgdata;
    }

    public static String bytes2Hex(byte[] bts)
    {
        StringBuffer des = new StringBuffer();
        String tmp = null;
        for (int i = 0; i < bts.length; i++)
        {
            tmp = (Integer.toHexString(bts[i] & 0xFF));
            if (tmp.length() == 1)
            {
                des.append("0");
            }
            des.append(tmp);
        }
        return des.toString();
    }

    public static byte[] hexStringToByteArray(String s)
    {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2)
        {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

    /**
     * Public key encryption
     */
    public static  String encryptByPublicKey(String data, String key)
    {

        try
        {
            byte[] keyBytes = Base64.decode(key, NO_WRAP);
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey pubKey = keyFactory.generatePublic(keySpec);
            Cipher cipher = Cipher.getInstance("RSA/ECB/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, pubKey);
            BigInteger da = new BigInteger(data , 16);
            byte[] mi = cipher.doFinal(da.toByteArray());

            return TestUtil.bytes2Hex(mi);
        }
        catch (NoSuchAlgorithmException e)
        {
            System.out.println("No such encryption algorithm");
        }
        catch (NoSuchPaddingException e)
        {
            e.printStackTrace();
            return null;
        }
        catch (InvalidKeyException e)
        {
            System.out.println("Encryption public key is illegal, please check");
        }
        catch (IllegalBlockSizeException e)
        {
            System.out.println("Plain text length is illegal");
        }
        catch (BadPaddingException e)
        {
            System.out.println("Clear text data is corrupted");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
