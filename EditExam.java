package com.example.newproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditExam extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_exam);

        MyDatabaseHelper myDB = new MyDatabaseHelper(this);
        Button addExam=findViewById(R.id.edit_exam_button);

        addExam.setOnClickListener(view -> {
            int id = Integer.parseInt(((EditText)(findViewById(R.id.edit_exam_id))).getText().toString());
            String examType=((EditText)(findViewById(R.id.edit_exam_type))).getText().toString();
            double mark = Double.parseDouble(((EditText)(findViewById(R.id.edit_exam_mark))).getText().toString());
            double duration = Double.parseDouble(((EditText)(findViewById(R.id.edit_exam_duration))).getText().toString());
            String examDate=((EditText)(findViewById(R.id.edit_exam_date))).getText().toString();

            Teacher t = new Teacher(0, 0, "", "", "", 0);
            t.edit_exam(id, examType, mark, duration, examDate, myDB);
        });
    }
}

