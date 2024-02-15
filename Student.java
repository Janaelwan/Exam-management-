package com.example.newproject;

import android.content.Context;
import android.widget.Toast;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Student implements User {
    private final int id ;
    private final String user_name;
    private final String password;
    private final String name;
    private final int grade;

    public Student(int id, String user_name, String password, String name, int grade) {
        this.id = id;
        this.user_name = user_name;
        this.password = password;
        this.name = name;
        this.grade = grade;
    }

    public User login(MyDatabaseHelper myDB) {
        return myDB.login("student", user_name, password);
    }

    public void take_exam(int examId, double grade, MyDatabaseHelper myDB) {
        Exam exam = myDB.getExam(examId);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        myDB.addConductedExam(this.id, exam.getSubject_id(), exam.getExamType(), grade, dtf.format(now));
    }

    public List<ConductedExam> view_grades(MyDatabaseHelper myDB) {
        return  myDB.getStudentConductedExams(this.id);
    }
    public void write_notes(String note)
    {
        Principal p = Principal.getInstance();
        p.add_notes(this.id, note);
    }

    public void sendNotification(String message, Context context)
    {
        Toast.makeText(context, "notification to :" + name + "message is: "+ message, Toast.LENGTH_SHORT).show();
        //System.out.println("notification to :" + name + "message is:" + message);
    }

    public int getId() {
        return id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }
}