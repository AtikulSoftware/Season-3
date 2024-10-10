package com.example.season3;



import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.season3.oopConcepts.class3003.Class3003Activity;
import com.example.season3.oopConcepts.class3004.Class3004Activity;
import com.example.season3.oopConcepts.class3005.Class3005Activity;
import com.example.season3.oopConcepts.class3009.Class3009Activity;
import com.example.season3.oopConcepts.class3010.Class3010Activity;
import com.example.season3.oopConcepts.class3013.hw1.Class3013Hw1Activity;
import com.example.season3.oopConcepts.class3013.hw2.Class3013Hw2Activity;
import com.example.season3.sqlite_database_section2.Db1Activity;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    HashMap<String, String> hashMap;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // পরিচয় করিয়ে দেওয়া হয়েছে ।
        listView = findViewById(R.id.listView);

        // data get করা হয়েছে ।
        getData();

        // Adapter কে call করা হয়েছে এবং listview তে set করে দেওয়া হয়েছে ।
        MyAdapter myAdapter = new MyAdapter();
        listView.setAdapter(myAdapter);


    } // on Create method end here =================


    private class MyAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            @SuppressLint("ViewHolder") View myView = layoutInflater.inflate(R.layout.list_view_item_layout, parent, false);

            // textview কে পরিচয় করিয়ে দেওয়া হয়েছে ।
            TextView Title = myView.findViewById(R.id.title);
            TextView Description = myView.findViewById(R.id.description);

            // CardView / item layout কে পরিচয় করিয়ে দেওয়া হয়েছে ।
            MaterialCardView itemLayout = myView.findViewById(R.id.itemLayout);

            // ArrayList থেকে data get করা হয়েছে ।
            HashMap<String, String> myHashmap = arrayList.get(position);

            String title = myHashmap.get("title");
            String description = myHashmap.get("description");

            // data list item এর মধ্যে set করে দেওয়া হয়েছে ।
            Title.setText(title);
            Description.setText(description);


            String activityName = myHashmap.get("activityName");

            itemLayout.setOnClickListener(v -> {
                if (activityName.equals("Class3003Activity")) {
                    // Class3003Activity
                    startActivity(new Intent(MainActivity.this, Class3003Activity.class));
                }  else if (activityName.equals("Class3004Activity")){
                    // Class3004Activity
                    startActivity(new Intent(MainActivity.this, Class3004Activity.class));
                } else if (activityName.equals("Class3005Activity")){
                    // Class3005Activity
                    startActivity(new Intent(MainActivity.this, Class3005Activity.class));
                }else if (activityName.equals("Class3009Activity")){
                    // Class3005Activity
                    startActivity(new Intent(MainActivity.this, Class3009Activity.class));
                } else if (activityName.equals("Class3010Activity")){
                    // Class3005Activity
                    startActivity(new Intent(MainActivity.this, Class3010Activity.class));
                } else if (activityName.equals("Class3013Hw1Activity")){
                    // Class3005Activity
                    startActivity(new Intent(MainActivity.this, Class3013Hw1Activity.class));
                } else if (activityName.equals("Class3013Hw2Activity")){
                    // Class3005Activity
                    startActivity(new Intent(MainActivity.this, Class3013Hw2Activity.class));
                } else if (activityName.equals("Db1Activity")){
                    // Class3005Activity
                    startActivity(new Intent(MainActivity.this, Db1Activity.class));
                }
            });

            return myView;
        }
    } // MyAdapter end here ===========


    private void getData() {
        // Class3003Activity
        hashMap = new HashMap<>();
        hashMap.put("activityName", "Class3003Activity");
        hashMap.put("title", "Employee Details With Java Class");
        hashMap.put("description", "Class3003Activity Employee Details With Java Class");
        arrayList.add(hashMap);

        //Class3004Activity
        hashMap = new HashMap<>();
        hashMap.put("activityName", "Class3004Activity");
        hashMap.put("title", "Employee Details With getter and setter in java");
        hashMap.put("description", "Class3004Activity Employee Details With getter and setter in java");
        arrayList.add(hashMap);

        //Class3005Activity
        hashMap = new HashMap<>();
        hashMap.put("activityName", "Class3005Activity");
        hashMap.put("title", "Employee Details using getter with Constructor in java");
        hashMap.put("description", "Class3005Activity Employee Details using getter with Constructor in java");
        arrayList.add(hashMap);

        //Class3009Activity
        hashMap = new HashMap<>();
        hashMap.put("activityName", "Class3009Activity");
        hashMap.put("title", "Employee Tax info Calculation");
        hashMap.put("description", "Class3009Activity Employee Tax info Calculation. Abstraction");
        arrayList.add(hashMap);

        //Class3010Activity
        hashMap = new HashMap<>();
        hashMap.put("activityName", "Class3010Activity");
        hashMap.put("title", "Employee Tax info Calculation Smartly");
        hashMap.put("description", "Class3010Activity Calculation Direct Call the Abstract Class");
        arrayList.add(hashMap);

        //Class3013Hw1Activity
        hashMap = new HashMap<>();
        hashMap.put("activityName", "Class3013Hw1Activity");
        hashMap.put("title", "HomeWork_3013.1");
        hashMap.put("description", "Class3010Activity : HomeWork_3013.1");
        arrayList.add(hashMap);

        //Class3013Hw2Activity
        hashMap = new HashMap<>();
        hashMap.put("activityName", "Class3013Hw2Activity");
        hashMap.put("title", "HomeWork_3013.2");
        hashMap.put("description", "Class3013Hw2Activity : HomeWork_3013.2");
        arrayList.add(hashMap);

        //Db1Activity
        hashMap = new HashMap<>();
        hashMap.put("activityName", "Db1Activity");
        hashMap.put("title", "Sqlite Database");
        hashMap.put("description", "Db1Activity : Sqlite Data insert");
        arrayList.add(hashMap);


    } // getData end here ==================

} // public class end here =========================