package com.example.season3.oopConcepts.class3005;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.season3.R;

public class Class3005Activity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class3005);

        // পরিচয় করিয়ে দেওয়া হয়েছে ।
        textView = findViewById(R.id.textView);

        // obj এবং Constructor কে call করা হয়েছে ।
        Employee employee1 = new Employee("Atikul","App Developer",100000);

        // textview তে show করানো হয়েছে ।
        textView.append("Name: "+ employee1.getName()+"\n");
        textView.append("Position: "+ employee1.getPosition()+"\n");
        textView.append("Salary: "+ employee1.getSalary()+"\n");


        Employee employee2 = new Employee("Atikul","CEO",10000, 5, 5);


    } // onCreate method end here ===========


} // public class end here ====================