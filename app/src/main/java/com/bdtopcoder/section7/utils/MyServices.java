package com.bdtopcoder.section7.utils;

import android.util.Base64;
import android.util.Log;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class MyServices {
    public static String MY_KEY = "";

    public static String encrypt(String myData) {
        byte[] secureBytes = null;
        try {
            byte[] plainTextBytes = myData.getBytes("UTF-8");
            byte[] passwordBytes = MY_KEY.getBytes("UTF-8");
            SecretKeySpec secretKey = new SecretKeySpec(passwordBytes, "AES");

            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            secureBytes = cipher.doFinal(plainTextBytes);
        } catch (Exception e) {
            Log.d("MyServices", "encrypt: " + e.getMessage());
        }
        return Base64.encodeToString(secureBytes, Base64.DEFAULT);
    } // class3052 end here ============

}
