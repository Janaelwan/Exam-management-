package com.example.newproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViewStudents extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_students);

        MyDatabaseHelper myDB = new MyDatabaseHelper(this);
        Principal principal = Principal.getInstance();

        List<Student> students = principal.students_details(myDB);
        List<String> studentsNames = new ArrayList<>();

        for (int i = 0; i < students.size(); i++) {
            studentsNames.add(students.get(i).getName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, studentsNames);
        ListView listView = findViewById(R.id.listViewStudent);
        listView.setAdapter(adapter);
    }
}