package com.example.season3.oopConcepts.class3009;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.season3.R;

public class Class3009Activity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class3009);

        // textview কে পরিচয় করিয়ে দেওয়া হয়েছে ।
        textView = findViewById(R.id.textView);

        // full time employee info
        Employee fullTimeEmployee = new FullTimeEmployee("Atikul","Developer",5000);
        textView.append("Name: "+ fullTimeEmployee.getName() +"\n");
        textView.append("Position: "+fullTimeEmployee.getPosition() + "\n");
        textView.append("Main Salary: "+fullTimeEmployee.getSalary() + "\n");
        textView.append("Tax: "+fullTimeEmployee.calculateTax() + "\n");
        textView.append("Final Salary: "+ fullTimeEmployee.calculateFinalSalary() + "\n\n");

        // part time employee info
        Employee partTimeEmployee = new PartTimeEmployee("Atikul","Developer",5000);
        textView.append("Name: "+ partTimeEmployee.getName() +"\n");
        textView.append("Position: "+partTimeEmployee.getPosition() + "\n");
        textView.append("Main Salary: "+partTimeEmployee.getSalary() + "\n");
        textView.append("Tax: "+partTimeEmployee.calculateTax() + "\n");
        textView.append("Final Salary: "+ partTimeEmployee.calculateFinalSalary());


    } // onCreate method end here ===========


} // public class end here ==================