package com.bdtopcoder.section7;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bdtopcoder.section7.utils.MyMethod;
import com.bdtopcoder.section7.utils.MyServices;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.material.textfield.TextInputEditText;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class SignupActivity extends AppCompatActivity {

    ImageView imageProfile;
    TextView tvChangePhoto, btnLogin;
    TextInputEditText inputEmail, inputPassword, inputName;
    Button buttonSignup;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // initialize
        imageProfile = findViewById(R.id.imageProfile);
        tvChangePhoto = findViewById(R.id.tvChangePhoto);
        btnLogin = findViewById(R.id.btnLogin);
        inputEmail = findViewById(R.id.inputEmail);
        inputPassword = findViewById(R.id.inputPassword);
        inputName = findViewById(R.id.inputName);
        buttonSignup = findViewById(R.id.buttonSignup);

        // initialize
        sharedPreferences = getSharedPreferences(getString(R.string.app_name), MODE_PRIVATE);
        editor = sharedPreferences.edit();

        // go to login page
        btnLogin.setOnClickListener(v -> {
            startActivity(new Intent(SignupActivity.this, LoginActivity.class));
            finish();
        });

        // signup button
        buttonSignup.setOnClickListener(v -> {
            // get input form user
            String email = inputEmail.getText().toString();
            String password = inputPassword.getText().toString();
            String name = inputName.getText().toString();

            // get Image and convert byte array
            BitmapDrawable bitmapDrawable = (BitmapDrawable) imageProfile.getDrawable();
            Bitmap bitmap = bitmapDrawable.getBitmap();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 50, outputStream);
            byte[] imagesBytes = outputStream.toByteArray();
            String image = Base64.encodeToString(imagesBytes, Base64.DEFAULT);

            // signup
            signup(email, password, name, image);

        });

        // change image
        tvChangePhoto.setOnClickListener(v -> {
            if (isCameraPermission()) {
                ImagePicker.with(SignupActivity.this)
                        .maxResultSize(1000, 1000)
                        .compress(1024)
                        .createIntent(new Function1<Intent, Unit>() {
                            @Override
                            public Unit invoke(Intent intent) {
                                imagePickerLauncher.launch(intent);
                                return null;
                            }
                        });
            }
        });


    } // onCreate method end here ============

    private void signup(String email, String password, String name, String image) {
        String API_URL = "http://192.168.0.104/Apps/section_7/signup.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, API_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("Signup_Successfully")) {
                    editor.putString("email", email);
                    editor.apply();
                    Toast.makeText(SignupActivity.this, "Sign up successfully", Toast.LENGTH_SHORT).show();
                    Intent myIntent = new Intent(SignupActivity.this, LoginActivity.class);
                    myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(myIntent);
                } else {
                    MyMethod.dialog(SignupActivity.this, response);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error.getMessage() != null) {
                    MyMethod.dialog(SignupActivity.this, error.getMessage());
                } else {
                    MyMethod.dialog(SignupActivity.this, "An unknown error occurred");
                }
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> myMap = new HashMap<>();
                myMap.put("key", MyServices.encrypt("Atikul@123"));
                myMap.put("email", email);
                myMap.put("password", password);
                myMap.put("name", name);
                myMap.put("image", image);
                return myMap;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(SignupActivity.this);
        requestQueue.add(stringRequest);
    } // signup end here ====================


    // image picker library
    ActivityResultLauncher<Intent> imagePickerLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Uri uri = result.getData().getData();
                    try {
                        Bitmap imageBitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                        imageProfile.setImageBitmap(imageBitmap);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    Toast.makeText(this, "Image not capture", Toast.LENGTH_SHORT).show();
                }

            });

    // Camera Permission
    private boolean isCameraPermission() {
        boolean hasPermission = false;

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            hasPermission = true;
        } else {
            hasPermission = false;
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.CAMERA}, 101);
        }

        return hasPermission;
    }


} // public class end here ===================