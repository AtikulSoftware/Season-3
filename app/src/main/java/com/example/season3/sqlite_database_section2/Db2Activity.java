package com.example.season3.sqlite_database_section2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.season3.R;

public class Db2Activity extends AppCompatActivity {

    TextView textView;
    EditText edId,edName;
    Button btnID,btnName;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db2);

        // পরিচয় করিয়ে দেওয়া হয়েছে ।
        textView = findViewById(R.id.textView);
        edId = findViewById(R.id.edId);
        edName = findViewById(R.id.edName);
        btnID = findViewById(R.id.btnID);
        btnName = findViewById(R.id.btnName);

        // পরিচয় করিয়ে দেওয়া হয়েছে ।
        databaseHelper = new DatabaseHelper(Db2Activity.this);

        Cursor cursor = databaseHelper.getAllData();
        textView.append("Total Data: "+cursor.getCount() + "\n");

        while (cursor.moveToNext()){
            textView.append("ID: "+cursor.getString(0));
            textView.append(" Name: "+cursor.getString(1));
            textView.append(" Number: "+cursor.getString(2) + "\n");
        }

        btnID.setOnClickListener(v -> {
            String userId = edId.getText().toString();
            if (!userId.isEmpty()){
                textView.setText("");
                Cursor cursorByID = databaseHelper.searchDataById(Integer.parseInt(userId));

                while (cursorByID.moveToNext()){
                    textView.append("ID: "+cursorByID.getString(0));
                    textView.append(" Name: "+cursorByID.getString(1));
                    textView.append(" Number: "+cursorByID.getString(2) + "\n");
                }
            } else {
                edId.setError("Enter ID");
            }
        });

        btnName.setOnClickListener(v -> {
            String userName = edName.getText().toString();
            if (!userName.isEmpty()){
                textView.setText("");
                Cursor cursorByName = databaseHelper.searchDataByName(userName);
                while (cursorByName.moveToNext()){
                    textView.append("ID: "+cursorByName.getString(0));
                    textView.append(" Name: "+cursorByName.getString(1));
                    textView.append(" Number: "+cursorByName.getString(2) + "\n");
                }
            } else {
                edId.setError("Enter Name");
            }
        });


    } // onCreate method end here ===============


} // public class end here ======================