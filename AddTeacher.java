package com.example.newproject;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddTeacher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_teacher);

        MyDatabaseHelper db=new MyDatabaseHelper(this);
        Button add_teacher=findViewById(R.id.add_teacher_btn);

        add_teacher.setOnClickListener(view -> {
            int subjectId = Integer.parseInt(((EditText)(findViewById(R.id.add_teacher_subjectId))).getText().toString());
            String username = ((EditText)(findViewById(R.id.add_teacher_username))).getText().toString();
            String password = ((EditText)(findViewById(R.id.add_teacher_password))).getText().toString();
            String confirm_password=((EditText)(findViewById(R.id.add_teacher_conPassword))).getText().toString();
            String name=((EditText)(findViewById(R.id.add_teacher_name))).getText().toString();
            double salary= Integer.parseInt(((EditText)(findViewById(R.id.add_teacher_salary))).getText().toString());

            if(confirm_password.equals(password)){
                Principal p=Principal.getInstance();
                p.add_teacher(subjectId, username, password, name, salary,db);
            }
        });

    }
}