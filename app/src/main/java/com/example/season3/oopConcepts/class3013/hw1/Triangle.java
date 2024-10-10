package com.example.season3.oopConcepts.class3013.hw1;

public class Triangle extends Shape {

    public Triangle(double side1, double side2, double side3) {
        super(side1, side2, side3);
    }

    @Override
    public double getArea() {
        // ABC = √[s × (s – a) × (s – b) × (s – c)]
        double s = (getSide1() + getSide2() + getSide3()) / 2;
        return Math.sqrt(s * (s - getSide1()) * (s - getSide2()) * (s - getSide3()));
    }

    @Override
    public double getPerimeter() {
        // P = side1 + side2 + side3
        return getSide1() + getSide2() + getSide3();
    }


} // Triangle end here ========
