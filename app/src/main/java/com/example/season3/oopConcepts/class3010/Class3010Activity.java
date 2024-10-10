package com.example.season3.oopConcepts.class3010;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.season3.R;
import com.example.season3.oopConcepts.class3009.Employee;

public class Class3010Activity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class3010);

        // textView কে পরিচয় করিয়ে দেওয়া হয়েছে ।
        textView = findViewById(R.id.textView);

        // class 3009 এর Employee কে call করা হয়েছে ।
        Employee employee = new Employee("Name", "Developer", 5000) {
            @Override
            public float calculateTax() {
                return getSalary() * 5/100;
            }

            @Override
            public float calculateFinalSalary() {
                return getSalary() - calculateTax();
            }
        };

        textView.append("Name: "+ employee.getName() +"\n");
        textView.append("Position: "+employee.getPosition() + "\n");
        textView.append("Main Salary: "+employee.getSalary() + "\n");
        textView.append("Tax: "+employee.calculateTax() + "\n");
        textView.append("Final Salary: "+ employee.calculateFinalSalary());


    } // onCreate method end here =============



} // public class end here ====================