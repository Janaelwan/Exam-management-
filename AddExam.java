package com.example.newproject;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddExam extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exam);

        MyDatabaseHelper myDB = new MyDatabaseHelper(this);
        Button addExam=findViewById(R.id.add_exam_button);

        addExam.setOnClickListener(view -> {
            String examType=((EditText)(findViewById(R.id.add_exam_type))).getText().toString();
            double mark = Double.parseDouble(((EditText)(findViewById(R.id.add_exam_mark))).getText().toString());
            double duration = Double.parseDouble(((EditText)(findViewById(R.id.add_exam_duration))).getText().toString());
            String examDate=((EditText)(findViewById(R.id.add_exam_date))).getText().toString();

            Teacher t = new Teacher(0, 0, "", "", "", 0);
            t.add_exam(examType,mark,duration,examDate,myDB);
        });

    }
}