package com.example.newproject;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddStudent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        MyDatabaseHelper myDB = new MyDatabaseHelper(this);

        Button addStudentButton = findViewById(R.id.add_student_btn);
        addStudentButton.setOnClickListener(v -> {
            String username = ((EditText)findViewById(R.id.add_student_username)).getText().toString();
            String password = ((EditText)findViewById(R.id.add_student_password)).getText().toString();
            String name = ((EditText)findViewById(R.id.add_student_name)).getText().toString();
            int grade = Integer.parseInt(((EditText)findViewById(R.id.add_student_grade)).getText().toString());

            Principal p = Principal.getInstance();
            p.add_student(username, password, name, grade, myDB);
        });
    }
}