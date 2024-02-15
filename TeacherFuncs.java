package com.example.newproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TeacherFuncs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_funcs);
        Button Btn_sendNotification= findViewById(R.id.sendNotifications_Btn);
        Btn_sendNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoNotification=new Intent(TeacherFuncs.this,SendNotification.class);
                startActivity(gotoNotification);
            }
        });

        MyDatabaseHelper myDB = new MyDatabaseHelper(this);
        Button Btn_assignments= findViewById(R.id.assignments_Btn);
        Btn_assignments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Teacher t = new Teacher(0, 3, "", "", "", 0);
                t.assign_assignment(myDB);
                Toast.makeText(TeacherFuncs.this, "New Assignment Added", Toast.LENGTH_LONG).show();
                //Intent gotoAssignments=new Intent(TeacherFuncs.this,Assignments.class);
                //startActivity(gotoAssignments);
            }
        });

        Button Btn_deleteExam= findViewById(R.id.deleteExam_Btn);

        Btn_deleteExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoDeleteExam=new Intent(TeacherFuncs.this,DeleteExam.class);
                startActivity(gotoDeleteExam);
            }
        });
        Button Btn_editExam= findViewById(R.id.editExam_Btn);
        Btn_editExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoEditExam=new Intent(TeacherFuncs.this,EditExam.class);
                startActivity(gotoEditExam);
            }
        });
        Button Btn_addExam= findViewById(R.id.addNewExam_Btn);
        Btn_addExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoAddExam=new Intent(TeacherFuncs.this,AddExam.class);
                startActivity(gotoAddExam);
            }
        });

        Button Btn_grades = findViewById(R.id.gradeManagement_Btn);
        Btn_grades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoAddExam=new Intent(TeacherFuncs.this,GradeManagement.class);
                startActivity(gotoAddExam);
            }
        });

        Button Btn_logout=findViewById(R.id.logout_Btn);
        Btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoSchedule=new Intent(TeacherFuncs.this,MainActivity.class);
                startActivity(gotoSchedule);
            }
        });
    }
}