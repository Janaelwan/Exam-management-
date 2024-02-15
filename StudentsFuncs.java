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

public class StudentsFuncs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_funcs);

        Button Btn_writeNote=findViewById(R.id.writeNote_Btn);
        Btn_writeNote.setOnClickListener(view -> {
            Intent gotoWriteNote=new Intent(StudentsFuncs.this,WriteNote.class);
            startActivity(gotoWriteNote);
        });

        Button Btn_viewGrades=findViewById(R.id.viewGrades_Btn);
        Btn_viewGrades.setOnClickListener(view -> {
            //Toast.makeText(StudentsFuncs.this, "Grades not Published yet", Toast.LENGTH_LONG).show();
            Intent gotoGrades=new Intent(StudentsFuncs.this,ViewGrades.class);
            startActivity(gotoGrades);
        });

        Button Btn_takeExam=findViewById(R.id.takeExam_Btn);
        Btn_takeExam.setOnClickListener(view -> {
            Intent gotoExam=new Intent(StudentsFuncs.this,TakeExam.class);
            startActivity(gotoExam);
        });

        Button Btn_logout=findViewById(R.id.logout_Btn);
        Btn_logout.setOnClickListener(view -> {
            Intent gotoSchedule=new Intent(StudentsFuncs.this,MainActivity.class);
            startActivity(gotoSchedule);
        });
    }
}