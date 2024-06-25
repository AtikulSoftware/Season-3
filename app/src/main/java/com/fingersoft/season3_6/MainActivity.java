package com.fingersoft.season3_6;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.github.dhaval2404.imagepicker.ImagePicker;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize
        imageView = findViewById(R.id.imageView);
        tvResult = findViewById(R.id.tvResult);

        // submit button এর onClick লেখা হয়েছে ।
        findViewById(R.id.btnSubmit).setOnClickListener(v -> {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) imageView.getDrawable();
            Bitmap imageBitmap = bitmapDrawable.getBitmap();

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);

            byte[] imageByte = byteArrayOutputStream.toByteArray();
            String image64 = Base64.encodeToString(imageByte, Base64.DEFAULT);

            tvResult.setText(image64);
            uploadImage(image64);
        });

        // gallery থেকে ইমেজ get করা হয়েছে।
        imageView.setOnClickListener(v -> {
            // TODO: 25/6/24 get image from gallery
            /*Intent galleryIntent = new Intent(Intent.ACTION_PICK);
            galleryIntent.setType("image/*");
            galleryLauncher.launch(galleryIntent);*/

            // TODO: 25/6/24 get image from camera
            /*if (isCameraPermission()) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                cameraLauncher.launch(cameraIntent);
            }*/

            // TODO: 25/6/24 image pick using third party library
            if (isCameraPermission()) {
                ImagePicker.with(MainActivity.this)
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

    } // onCreate method end here ==============

    // image upload করা হয়েছে ।
    public void uploadImage(String image) {
        String API_URL = "http://192.168.0.102/Apps/season3_section6/image_upload.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, API_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                tvResult.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tvResult.setText(error.getMessage());
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map map = new HashMap<String, String>();
                map.put("image", image);
                return map;
            }
        };

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest);
    } // uploadImage end here ==========

    // gallery launcher
    ActivityResultLauncher<Intent> galleryLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {

                if (result.getResultCode() == Activity.RESULT_OK) {
                    Uri uri = result.getData().getData();

                    try {
                        Bitmap imageBitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                        imageView.setImageBitmap(imageBitmap);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    tvResult.setText("Image not selected");
                }
            });

    // camera launcher
    ActivityResultLauncher<Intent> cameraLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    // TODO: 25/6/24 get image thumbnail
                    Bundle bundle = result.getData().getExtras();
                    Bitmap bitmap = (Bitmap) bundle.get("data");
                    imageView.setImageBitmap(bitmap);
                } else {
                    tvResult.setText("Image not capture");
                }

            });

    // image picker library
    ActivityResultLauncher<Intent> imagePickerLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Uri uri = result.getData().getData();

                    try {
                        Bitmap imageBitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                        imageView.setImageBitmap(imageBitmap);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    tvResult.setText("Image not capture");
                }

            });

    // Camera Permission
    private boolean isCameraPermission() {
        boolean hasPermission = false;

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            hasPermission = true;
        } else {
            hasPermission = false;
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 101);
        }

        return hasPermission;
    }


} // public class end here ======================