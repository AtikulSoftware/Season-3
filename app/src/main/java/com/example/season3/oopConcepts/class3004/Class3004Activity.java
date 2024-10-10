package com.example.season3.oopConcepts.class3004;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.season3.R;

public class Class3004Activity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class3004);

        // পরিচয় করিয়ে দেওয়া হয়েছে ।
        textView = findViewById(R.id.textView);

        // Employee 1 এর জন্য ।
        Employee employee1 = new Employee();
        employee1.setName("Atikul");
        employee1.setPosition("Programmer");
        employee1.setSalary(10000);

        // Employee 2 এর জন্য ।
        Employee employee2 = new Employee();
        employee2.setName("Hasib");
        employee2.setPosition("Developer");
        employee2.setSalary(10000);

        //============================

        // Employee 1 কে get করা হয়েছে ।
        textView.append("Name: " + employee1.getName() + "\n");
        textView.append("Position: " + employee1.getPosition() + "\n");
        textView.append("Salary: " + employee1.getSalary() + "\n\n");

        // Employee 2 কে get করা হয়েছে ।
        textView.append("Name: " + employee2.getName() + "\n");
        textView.append("Position: " + employee2.getPosition() + "\n");
        textView.append("Salary: " + employee2.getSalary() + "\n");

    } // onCreate method end here ============


} // public class end here ===================