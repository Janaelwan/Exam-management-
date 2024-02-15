package com.example.newproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class DeleteExam extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_exam);

        MyDatabaseHelper myDB = new MyDatabaseHelper(this);

        Button deleteExam=findViewById(R.id.deleteExamtoSubject_Btn);

        deleteExam.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int id=Integer.parseInt((((EditText)(findViewById(R.id.subjectID)))).getText().toString());
                Teacher t = new Teacher(0, 0, "", "", "", 0);
                t.delete_exam(id,myDB);
            }
        });
    }
}