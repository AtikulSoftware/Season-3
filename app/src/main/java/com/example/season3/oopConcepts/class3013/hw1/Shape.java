package com.example.season3.oopConcepts.class3013.hw1;

public abstract class Shape {

    // Rectangle
    private double length;
    private double width;

    // Circle
    private double radius;

    // Triangle
    private double side1;
    private double side2;
    private double side3;


    public abstract double getArea();

    public abstract double getPerimeter();

    // for Rectangle
    public Shape(double length, double width) {
        this.length = length;
        this.width = width;
    }



    // for Circle
    public Shape(double radius) {
        this.radius = radius;
    }

    // for Triangle
    public Shape(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getRadius() {
        return radius;
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }
} // Shape end here ===========
