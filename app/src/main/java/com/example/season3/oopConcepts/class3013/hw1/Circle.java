package com.example.season3.oopConcepts.class3013.hw1;

public class Circle extends Shape {

    public Circle(double radius) {
        super(radius);
    }

    @Override
    public double getArea() {
        // Area = π × radius × radius
        return Math.PI * getRadius() * getRadius();
    }

    @Override
    public double getPerimeter() {
        // circle = 2πR
        return 2 * Math.PI * getRadius();
    }


} // Circle end here =======
