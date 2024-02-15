package com.example.newproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditStudent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);

        MyDatabaseHelper db=new MyDatabaseHelper(this);
        Button edit_student=findViewById(R.id.edit_student_btn);

        edit_student.setOnClickListener(view -> {
            int id = Integer.parseInt(((EditText)(findViewById(R.id.edit_student_id))).getText().toString());
            String username = ((EditText)findViewById(R.id.edit_student_username)).getText().toString();
            String password = ((EditText)findViewById(R.id.edit_student_password)).getText().toString();
            String name = ((EditText)findViewById(R.id.edit_student_name)).getText().toString();
            int grade = Integer.parseInt(((EditText)findViewById(R.id.edit_student_grade)).getText().toString());

            Principal p=Principal.getInstance();
            p.edit_student(id,username,password,name,grade,db);
        });
    }
}