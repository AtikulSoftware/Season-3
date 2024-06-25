package com.bdtopcoder.section5;

import android.os.Bundle;
import android.util.Base64;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class MainActivity extends AppCompatActivity {

    TextView tvResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize
        tvResult = findViewById(R.id.tvResult);

        // onClick
        findViewById(R.id.button).setOnClickListener(v -> {
            try {
                // TODO: 25/6/24 Class 3050: Data Encoding Techniques in Android
                // class3050();

                // TODO: 25/6/24 Class 3052: Data Encryption Using Cryptography
                //class3052();

                // TODO: 25/6/24 Class 3053: Secure Data Decryption with Cryptography
                class3053();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });


    } // onCreate method end here ======

    // TODO: 25/6/24 Class 3050: Data Encoding Techniques in Android
    private void class3050()throws Exception{
        String plainText = "I love you";
        byte[] plainTextByte = plainText.getBytes("UTF-8");

        String encodingString = Base64.encodeToString(plainTextByte, Base64.DEFAULT);
        tvResult.setText(encodingString);
    } // encryptData end here ============

    // TODO: 25/6/24 Class 3052: Data Encryption Using Cryptography
    private void class3052()throws Exception{
        String plainText = "I love you";
        byte[] plainTextBytes = plainText.getBytes("UTF-8");

        String password = "AywPhYorF8r4lpYk";
        byte[] passwordBytes = password.getBytes("UTF-8");
        SecretKeySpec secretKey = new SecretKeySpec(passwordBytes, "AES");

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] secureBytes = cipher.doFinal(plainTextBytes);

        String encodingString = Base64.encodeToString(secureBytes, Base64.DEFAULT);
        tvResult.setText(encodingString);
    } // class3052 end here ============

    // TODO: 25/6/24 Class 3053: Secure Data Decryption with Cryptography
    private void class3053()throws Exception{
        String encodeString = "G96ooyQFjfLXhPPC4WQcAQ==";
        byte[] decodeBytes = Base64.decode(encodeString, Base64.DEFAULT);

        String password = "AywPhYorF8r4lpYk";
        byte[] passwordBytes = password.getBytes("UTF-8");
        SecretKeySpec secretKey = new SecretKeySpec(passwordBytes, "AES");

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptBytes = cipher.doFinal(decodeBytes);

        String decryptData = new String(decryptBytes, "UTF-8");
        tvResult.setText(decryptData);
    } // class3053 end here ============


} // public class end here ==============