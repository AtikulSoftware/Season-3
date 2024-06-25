package com.bdtopcoder.section4;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    TextView tvResult;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize
        tvResult = findViewById(R.id.tvResult);
        progressBar = findViewById(R.id.progressBar);

        // button onClick
        findViewById(R.id.btnApiCall).setOnClickListener(v -> {

            // TODO: 25/6/24  Class 3044: Secure String Request -Android to PHP
            // class3044();

            // TODO: 25/6/24 Class 3045: Secure JSONObject Request -Android to PHP
            // class3045();

            // TODO: 25/6/24
            class3047();


        });

    } // onCrete method end here ==================

    // TODO: 25/6/24 String Request
    private void class3044() {
        String API = "http://192.168.0.102/Apps/section%204/class_3044/index.php";
        progressBar.setVisibility(View.VISIBLE);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, API, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressBar.setVisibility(View.GONE);
                tvResult.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.GONE);

            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map map = new HashMap<String, String>();
                map.put("password", "123456");
                map.put("email", "atikul@gmail.com");
                return map;
            }
        };

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest);
    } // class3044 end here ============

    // TODO: 25/6/24 Object Request
    private void class3045() {
        String API = "http://192.168.0.102//Apps/section%204/class_3045/index.php";
        progressBar.setVisibility(View.VISIBLE);

        // create json obj
        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("password", "123456");
            jsonObject.put("email", "atikul@gmail.com");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, API, jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                progressBar.setVisibility(View.GONE);
                tvResult.setText(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.GONE);
                tvResult.setText(error.getMessage());
            }
        });


        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(jsonObjectRequest);
    } // class3045 end here ============

    private void class3047() {
        String API = "http://192.168.0.102//Apps/section%204/class_3047/index.php";
        progressBar.setVisibility(View.VISIBLE);

        JSONArray jsonArray = new JSONArray();
        // create json obj
        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("password", "123456");
            jsonObject.put("email", "atikul@gmail.com");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        jsonArray.put(jsonObject);

        // create json array req
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, API, jsonArray, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                progressBar.setVisibility(View.GONE);
                tvResult.setText(response.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.GONE);
                tvResult.setText(error.getMessage());
            }
        });


        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(jsonArrayRequest);
    } // class3047 end here ============


} // public class end here =================