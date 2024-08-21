package com.bdtopcoder.section7;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bdtopcoder.section7.utils.MyMethod;
import com.bdtopcoder.section7.utils.MyServices;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ImageView imgProfile;
    TextView tvName,tvEmail;
    Button btnLogOut;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize
        imgProfile = findViewById(R.id.imgProfile);
        tvEmail = findViewById(R.id.tvEmail);
        tvName = findViewById(R.id.tvName);
        btnLogOut = findViewById(R.id.btnLogOut);

        // initialize
        sharedPreferences = getSharedPreferences(getString(R.string.app_name), MODE_PRIVATE);
        editor = sharedPreferences.edit();
        MyServices.MY_KEY = "AywPhYorF8r4lpYk";

        // check user login or not
        String email = sharedPreferences.getString("email", "");
        if (email.isEmpty()){
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        } else {
            getProfile(email);
        }

        btnLogOut.setOnClickListener(v -> {
            editor.putString("email", "");
            editor.apply();
            Toast.makeText(MainActivity.this, "Logout successfully", Toast.LENGTH_SHORT).show();
            Intent myIntent = new Intent(MainActivity.this, LoginActivity.class);
            myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(myIntent);
        });

    } // onCreate method ene here =============

    private void getProfile(String email) {
        String API = "http://192.168.0.104/Apps/section_7/profile.php";
        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("key", MyServices.encrypt("Atikul@123"));
            jsonObject.put("email", email);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, API, jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    String name = response.getString("name");
                    String email = response.getString("email");
                    String image = response.getString("image");
                    tvName.setText(name);
                    tvEmail.setText(email);
                    Picasso.get()
                            .load(image)
                            .placeholder(R.drawable.ic_launcher_background)
                            .into(imgProfile);
                }catch (Exception e){
                    Log.d("Profile", "onResponse: "+e.getMessage());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                MyMethod.dialog(MainActivity.this, error.getMessage());
            }
        });

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(jsonObjectRequest);
    } // class3045 end here ============

} // public class end here ====================