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

public class ViewTeachers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_teachers);

        MyDatabaseHelper myDB = new MyDatabaseHelper(this);
        Principal principal = Principal.getInstance();

        List<Teacher> teachers = principal.teachers_details(myDB);
        List<String> teachersNames = new ArrayList<>();

        for (int i = 0; i < teachers.size(); i++) {
            teachersNames.add(teachers.get(i).getName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, teachersNames);
        ListView listView = findViewById(R.id.listViewTeacher);
        listView.setAdapter(adapter);
    }
}