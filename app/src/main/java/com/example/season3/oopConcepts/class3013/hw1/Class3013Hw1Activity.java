package com.example.season3.oopConcepts.class3013.hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.season3.R;

public class Class3013Hw1Activity extends AppCompatActivity {


    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class3013_hw1);

        // পরিচয় করিয়ে দেওয়া হয়েছে ।
        textView = findViewById(R.id.textView);

        Shape rectangle = new Rectangle(10,12);
        Shape circle = new Circle(5);
        Shape triangle = new Triangle(7, 8, 6);

        textView.append(" HomeWork_3013.1 \n\n\n");

        // Rectangle
        textView.append("Output\n");
        textView.append("Area and perimeter of various shapes: \n");
        textView.append("Rectangle: Length:"+rectangle.getLength()+", Width:"+rectangle.getWidth() + "\n");
        textView.append("Rectangle: Length:");
        textView.append("Area: " + rectangle.getArea() + "\n");
        textView.append("Perimeter: " + rectangle.getPerimeter() + "\n\n");

        // Circle
        textView.append("Circle: Radius:"+circle.getRadius());
        textView.append("Area: " + circle.getArea() + "\n");
        textView.append("Perimeter: " + circle.getPerimeter() +"\n\n");

        // Triangle
        textView.append("Triangle: Side1:"+triangle.getSide1() + " Side2:"+triangle.getSide2() + " Side3:"+triangle.getSide3() +"\n");
        textView.append("Area: " + triangle.getArea() + "\n");
        textView.append("Perimeter: " + triangle.getPerimeter());



    } // onCreate method end here ===========


} // public class end here ==================