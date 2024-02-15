package com.example.newproject;

public class Director {
    ExamBuilder examBuilder;
    public void setExamBuilder(ExamBuilder builder){
        examBuilder=builder;
    }
    public Exam getExam(){
        return examBuilder.getExam();
    }
    public void construct(int subject_id, String examDate, ExamBuilder examBuilder){
        setExamBuilder(examBuilder);
        examBuilder.createExam();
        examBuilder.buildExamType();
        examBuilder.buildExamDate(examDate);
        examBuilder.buildSubject(subject_id);

    }
}
