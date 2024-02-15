package com.example.newproject;

import android.os.Build;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Principal implements User{
    private final String username;
    private final String password;
    private static Principal instance;
    private Principal(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static Principal getInstance() {
        if(instance == null )
            instance = new Principal("principal", "123456");
        return instance;
    }

    public User login(String username , String password)
    {
        Principal p = Principal.getInstance();
        User principle = null;
        if(username.equals(p.username) && password.equals(p.password)) {
            principle = p;
        }
        return principle;
    }
    ///////////////personal data for teacher/////////////////////////////////
    public void add_teacher (int subjectId, String username, String password, String name, double salary, MyDatabaseHelper myDB)
    {
        myDB.addTeacher(subjectId, username, password, name, salary);
    }
    public void edit_teacher (int id, int subjectId, String username, String password, String name, double salary, MyDatabaseHelper myDB)
    {
        myDB.updateTeacher(id, subjectId, username, password, name, salary);
    }
    public void delete_teacher (int id, MyDatabaseHelper myDB)
    {
        myDB.deleteTeacher(id);
    }
    ////////////////personal data for student//////////////////
    public void add_student(String username, String password, String name, int grade, MyDatabaseHelper myDB)
    {
        myDB.addStudent(username, password, name, grade);
    }
    public void edit_student ( int id, String username, String password, String name, int grade, MyDatabaseHelper myDB)
    {
        myDB.updateStudent(id, username, password, name, grade);
    }
    public void delete_student (int id, MyDatabaseHelper myDB)
    {
        myDB.deleteStudent(id);
    }
    ////////////show details/////////////////////////
    public List<Teacher> teachers_details(MyDatabaseHelper myDB)
    {
        return myDB.getAllTeachers();
    }
    public List<Student> students_details(MyDatabaseHelper myDB)
    {
        return myDB.getAllStudents();
    }
    public List<ConductedExam> get_exams_info(MyDatabaseHelper myDB)
    {
        return myDB.getAllConductedExams();
    }
    //////////////time table///////////////////
    Map< String ,LocalTime> table;
    public void prepare_timetable(MyDatabaseHelper myDB)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            table.put("math", LocalTime.of(8,0));
        }
        myDB.addSubject("math", 1, false, "8:00");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            table.put("science", LocalTime.of(10,0));
        }
        myDB.addSubject("science", 2, false, "10:00");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            table.put("prob", LocalTime.of(12,0));
        }
        myDB.addSubject("prob", 3, false, "12:00");
    }
    Map<Integer ,String> notes = new HashMap<>();
    public void add_notes(int id , String content)
    {
        notes.put(id, content);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}