package com.example.newproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ViewGrades extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_grades);

        MyDatabaseHelper myDB = new MyDatabaseHelper(this);

        RecyclerView recyclerView = findViewById(R.id.recycleview);
        List<ConductedExam> exams = myDB.getStudentConductedExams(3);
        System.out.println(exams.size());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new Myadapter(getApplicationContext(),exams, myDB));
    }
}