package com.example.season3.oopConcepts.class3013.hw2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import com.example.season3.R;

import java.time.LocalDate;
import java.time.Period;

public class Class3013Hw2Activity extends AppCompatActivity {

    TextView textView;

   // @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class3013_hw2);

        // পরিচয় করিয়ে দেওয়া হয়েছে ।
        textView = findViewById(R.id.textView);

        textView.append("HomeWork_3013.2 \n\n");

        Employee employee1 = new Employee("Atikul", 1000, LocalDate.parse("2021-04-01"));







        textView.append("Name: " + employee1.getName() + "\n");
        textView.append("Salary: " + employee1.getSalary() + "\n");
        textView.append("HireDate: " + employee1.getHireDate() + "\n");
        textView.append("Years of Service: " + employee1.getYearsOfService().getYears() + " Year " + employee1.getYearsOfService().getMonths() + " Months " + employee1.getYearsOfService().getDays() + " Days\n\n");

        Employee employee2 = new Employee("Hasib", 2000, LocalDate.parse("2010-01-01"));
        textView.append("Name: " + employee2.getName() + "\n");
        textView.append("Salary: " + employee2.getSalary() + "\n");
        textView.append("HireDate: " + employee2.getHireDate() + "\n");
        textView.append("Years of Service: " + employee2.getYearsOfService().getYears() + " Year " + employee2.getYearsOfService().getMonths() + " Months " + employee2.getYearsOfService().getDays() + " Days");

    } // onCreate method end here =============


} // public class end here ====================