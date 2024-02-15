package com.example.newproject;

public class Exam {
    private int id;
    private int subject_id;
    private String examType;
    private double mark;
    private double duration;
    private String start_date;

    public Exam() {}

    public Exam(int id, int subjectId, String examType, double mark, double duration, String startDate) {
        this.id = id;
        this.subject_id = subjectId;
        this.examType = examType;
        this.mark = mark;
        this.duration = duration;
        this.start_date = startDate;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public String getExamType() {
        return examType;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }
}
