package com.example.season3.oopConcepts.class3013.hw1;

public class Rectangle extends Shape {

    public Rectangle(double length, double width) {
        super(length, width);
    }

    @Override
    public double getArea() {
        // Area of a rectangle = length × width
        return getLength() * getWidth();
    }

    @Override
    public double getPerimeter() {
        // Perimeter = (length + width) × 2
        return (getLength() + getWidth()) * 2;
    }


} // Rectangle end here ======
