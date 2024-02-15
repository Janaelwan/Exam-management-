package com.example.newproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.widget.Button;

public class ThePrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_principal);

        Button Btn_addTeacher=findViewById(R.id.addTeacherNewt_Btn);
        Btn_addTeacher.setOnClickListener(view -> {
            Intent gotoAddTeacher=new Intent(ThePrincipal.this,AddTeacher.class);
            startActivity(gotoAddTeacher);
        });

        Button Btn_editTeacher=findViewById(R.id.editTeacher_Btn);
        Btn_editTeacher.setOnClickListener(view -> {
            Intent gotoAddTeacher=new Intent(ThePrincipal.this,EditTeacher.class);
            startActivity(gotoAddTeacher);
        });

        Button Btn_deleteTeacher=findViewById(R.id.deleteTeacher_Btn);
        Btn_deleteTeacher.setOnClickListener(view -> {
            Intent gotoAddTeacher=new Intent(ThePrincipal.this,DeleteTeacher.class);
            startActivity(gotoAddTeacher);
        });

        Button Btn_addStudent=findViewById(R.id.addNewStudent_Btn);
        Btn_addStudent.setOnClickListener(view -> {
            Intent gotoaddStudent=new Intent(ThePrincipal.this,AddStudent.class);
            startActivity(gotoaddStudent);
        });

        Button Btn_editStudent=findViewById(R.id.editStudent_Btn);
        Btn_editStudent.setOnClickListener(view -> {
            Intent gotoAddTeacher=new Intent(ThePrincipal.this,EditStudent.class);
            startActivity(gotoAddTeacher);
        });

        Button Btn_deleteStudent=findViewById(R.id.deleteStudent_Btn);
        Btn_deleteStudent.setOnClickListener(view -> {
            Intent gotoAddTeacher=new Intent(ThePrincipal.this,DeleteStudent.class);
            startActivity(gotoAddTeacher);
        });

        Button Btn_viewTeachers=findViewById(R.id.teacherView_Btn);
        Btn_viewTeachers.setOnClickListener(view -> {
            Intent gotoViewTeacher=new Intent(ThePrincipal.this,ViewTeachers.class);
            startActivity(gotoViewTeacher);
        });

        Button Btn_viewTStudents=findViewById(R.id.viewStudents_Btn);
        Btn_viewTStudents.setOnClickListener(view -> {
            Intent gotoviewStudents=new Intent(ThePrincipal.this,ViewStudents.class);
            startActivity(gotoviewStudents);
        });

        Button Btn_viewExams=findViewById(R.id.viewExams_Btn);
        Btn_viewExams.setOnClickListener(view -> {
            Intent gotoviewExams=new Intent(ThePrincipal.this,ViewExams.class);
            startActivity(gotoviewExams);
        });


        Button Btn_Schedule=findViewById(R.id.schedule_Btn);
        Btn_Schedule.setOnClickListener(view -> {
            Intent gotoSchedule=new Intent(ThePrincipal.this,Schedule.class);
            startActivity(gotoSchedule);
        });

        Button Btn_logout=findViewById(R.id.logout_Btn);
        Btn_logout.setOnClickListener(view -> {
            Intent gotoSchedule=new Intent(ThePrincipal.this,MainActivity.class);
            startActivity(gotoSchedule);
        });
    }
}