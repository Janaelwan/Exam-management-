package com.example.newproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GradeManagement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade_management);

        MyDatabaseHelper myDB = new MyDatabaseHelper(this);
        Button viewGradesBtn = findViewById(R.id.view_grades_btn);
        viewGradesBtn.setOnClickListener(v -> {
            int student_id = Integer.parseInt(((EditText)findViewById(R.id.grades_student_id)).getText().toString());

            Teacher teacher = new Teacher(4, 2, "", "", "", 0);
            List<ConductedExam> exams = teacher.check_grade(student_id, myDB);
            List<Double> grades = new ArrayList<>();

            for(ConductedExam exam : exams) {
                grades.add(exam.getGrade());
            }

            ArrayAdapter<Double> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, grades);
            ListView listView = findViewById(R.id.student_grades);
            listView.setAdapter(adapter);
        });
    }
}