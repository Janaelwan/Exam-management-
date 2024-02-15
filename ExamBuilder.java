package com.example.newproject;

public abstract class ExamBuilder {
    protected Exam exam;

    public Exam getExam() {
        return exam;
    }

    void createExam() {
        exam = new Exam();
    }

    abstract Exam buildExamType();

    abstract void buildSubject(int subject_id);

    abstract void buildExamDate(String examDate);

    abstract void buildMark(double grade);
}
