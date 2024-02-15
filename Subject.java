package com.example.newproject;
public class Subject {
    private int id;
    private String name;
    private int grade;
    private boolean has_assignment;
    private String time;

    public Subject(int id, String name, int grade, boolean has_assignment, String time) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.has_assignment = has_assignment;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public int getId() {
        return id;
    }

    public String getTime() {
        return time;
    }
}
