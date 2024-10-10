package com.example.season3.oopConcepts.class3003;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.season3.R;

public class Class3003Activity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class3003);

        // পরিচয় করিয়ে দেওয়া হয়েছে ।
        textView = findViewById(R.id.textView);

        // employee এর ১ম  obj create করা হয়েছে ।
        Employee employee1 = new Employee();
        employee1.name = "Atikul";
        employee1.position = "App Developer";
        employee1.salary = 10000;

        // employee এর ২য় obj create করা হয়েছে ।
        Employee employee2 = new Employee();
        employee2.name = "Hasib";
        employee2.position = "Web Developer";
        employee2.salary = 10000;

        // textView তে employee1 দেখানো হয়েছে ।
        textView.append("Name: "+ employee1.name + "\n");
        textView.append("Position: "+ employee1.position + "\n");
        textView.append("Salary: "+ employee1.salary + "\n\n");

        // textView তে employee2 দেখানো হয়েছে ।
        textView.append("Name: "+ employee2.name + "\n");
        textView.append("Position: "+ employee2.position + "\n");
        textView.append("Salary: "+ employee2.salary + "\n");

    } // onCreate end here ===============


} // public class end here ================