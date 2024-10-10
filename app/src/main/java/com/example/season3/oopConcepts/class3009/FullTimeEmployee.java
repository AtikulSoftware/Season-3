package com.example.season3.oopConcepts.class3009;

public class FullTimeEmployee extends Employee{
    public FullTimeEmployee(String name, String position, float salary) {
        super(name, position, salary);
    }

    @Override
    public float calculateTax() {
        return getSalary() * 5/100;
    }

    @Override
    public float calculateFinalSalary() {
        return getSalary() - calculateTax();
    }
}
