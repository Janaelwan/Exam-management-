package com.example.newproject;

public class MothlyExamBuilder extends ExamBuilder{
    String type="Monthly";


    @Override
    Exam buildExamType(){
        ExamFactory factory = new ExamFactory();
        return factory.createExam(type);

    }

    @Override
    void buildSubject(int subject_id) {
        getExam().setSubject_id(subject_id);
    }

    @Override
    void buildExamDate(String examDate) {
        getExam().setStart_date(examDate);
    }

    @Override
    void buildMark(double mark) {
        getExam().setMark(mark);
    }
}
