package com.example.season3.oopConcepts.class3009;

public abstract class Employee {
    private String name;
    private String position;
    private float salary;

    public abstract float calculateTax();
    public abstract float calculateFinalSalary();

    public Employee(String name, String position, float salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public float getSalary() {
        return salary;
    }
}
