package com.example.season3.oopConcepts.class3005;

public class Employee {
    private String name;
    private String position;
    private float salary;

    public Employee(String name, String position, float salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public Employee(String name, String position, float salary,float absent ,float overTime) {
        this.name = name;
        this.position = position;
        this.salary = salary - ((absent*500) +(overTime*600));
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
