package com.example.season3.oopConcepts.class3009;

public class PartTimeEmployee extends Employee{
    public PartTimeEmployee(String name, String position, float salary) {
        super(name, position, salary);
    }

    @Override
    public float calculateTax() {
        return getSalary() * 10/100;
    }

    @Override
    public float calculateFinalSalary() {
        return getSalary() - calculateTax();
    }
}
