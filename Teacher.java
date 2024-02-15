package com.example.newproject;

import android.content.Context;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

public class Teacher implements User {
    private int id ;
    private int subject_id;
    private String user_name;
    private String password;
    private String name;
    private double salary;

    public Teacher(int id, int subject_id, String user_name, String password, String name, double salary) {
        this.id = id;
        this.subject_id = subject_id;
        this.user_name = user_name;
        this.password = password;
        this.name = name;
        this.salary = salary;
    }
    private List<Command> doit = new ArrayList<>();

    synchronized void addCommand(Command command) {
        doit.add(command);
    }

    synchronized void executeCommands(Context context) {
        for (Command command : doit) {
            command.execute(context);
        }
        doit.clear();
    }

    public User login(MyDatabaseHelper myDB) {
        return myDB.login("teacher", user_name, password);
    }
    public void add_exam(String examType, double mark, double duration, String examDate, MyDatabaseHelper myDB)
    {
        Director director = new Director();
        director.construct(this.subject_id, examDate, new MothlyExamBuilder());
        myDB.addExam(this.subject_id, examType, mark, duration, examDate);
    }
    public void edit_exam(int id, String examType, double mark, double duration, String examDate, MyDatabaseHelper myDB)
    {
        myDB.updateExam(id, this.subject_id, examType, mark, duration, examDate);
    }
    public void delete_exam(int id, MyDatabaseHelper myDB)
    {
        myDB.deleteExam(id);
    }

    public List<ConductedExam> check_grade(int id, MyDatabaseHelper myDB)
    {
        return  myDB.getStudentExamsAtSubject(id, this.subject_id);
    }

    public void assign_assignment(MyDatabaseHelper myDB)
    {
        Subject subject = myDB.getSubject(this.subject_id);
        myDB.updateSubject(subject.getId(), subject.getName(), subject.getGrade(), true, subject.getTime());
    }

    public int getId() {
        return id;
    }

    public int getSubject_id() {
        return subject_id;
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

    public double getSalary() {
        return salary;
    }
}
