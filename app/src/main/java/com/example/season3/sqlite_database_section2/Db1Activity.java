package com.example.season3.sqlite_database_section2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.season3.R;

public class Db1Activity extends AppCompatActivity {

    EditText edName, edNumber;
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db1);

        // পরিচয় করিয়ে দেওয়া হয়েছে ।
        edName = findViewById(R.id.edName);
        edNumber = findViewById(R.id.edNumber);

        // পরিচয় করিয়ে দেওয়া হলো ।
        databaseHelper = new DatabaseHelper(Db1Activity.this);

        // insertButton  এর onCLick লেখা হয়েছে ।
        findViewById(R.id.btnInsert).setOnClickListener(v -> {
            // get get করা হয়েছে ।
            String name = edName.getText().toString();
            String number = edNumber.getText().toString();

            if (!name.isEmpty() && !number.isEmpty()){
                databaseHelper.insertData(name, number);
                Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show();
            } else {
                edName.setError("Enter Name");
                edNumber.setError("Enter Number");
            }

        });

        // btn show তে ক্লিক করা হয়েছে ।
        findViewById(R.id.btnShow).setOnClickListener(v -> {
            startActivity(new Intent(Db1Activity.this, Db2Activity.class));
        });

    } // onCreate method end here ================


} // public class end here ======================