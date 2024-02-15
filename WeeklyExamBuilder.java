package com.example.newproject;

import java.util.Date;

public class WeeklyExamBuilder extends ExamBuilder {
    String type="weekly";
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
