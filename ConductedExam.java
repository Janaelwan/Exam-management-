package com.example.newproject;

public class ConductedExam{
    private int id;
    private int student_id;
    private int subject_id;
    private String type;
    private double grade;
    private String date;

    public ConductedExam(int id, int student_id, int subject_id, String type, double grade, String date) {
        this.id = id;
        this.student_id = student_id;
        this.subject_id = subject_id;
        this.type = type;
        this.grade = grade;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public String getType() {
        return type;
    }

    public String getDate() {
        return date;
    }

    public double getGrade() {
        return grade;
    }
}