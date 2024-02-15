package com.example.newproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditTeacher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_teacher);

        MyDatabaseHelper db=new MyDatabaseHelper(this);
        Button edit_teacher=findViewById(R.id.edit_teacher_btn);

        edit_teacher.setOnClickListener(view -> {

            int id = Integer.parseInt(((EditText)(findViewById(R.id.edit_teacher_id))).getText().toString());
            int subjectId = Integer.parseInt(((EditText)(findViewById(R.id.edit_teacher_subjectId))).getText().toString());
            String username = ((EditText)(findViewById(R.id.edit_teacher_username))).getText().toString();
            String password = ((EditText)(findViewById(R.id.edit_teacher_password))).getText().toString();
            String name=((EditText)(findViewById(R.id.edit_teacher_name))).getText().toString();
            double salary= Integer.parseInt(((EditText)(findViewById(R.id.edit_teacher_salary))).getText().toString());

            Principal p1 = Principal.getInstance();
            p1.edit_teacher(id, subjectId,username,password,name,salary,db);
        });
    }
}