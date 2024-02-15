package com.example.newproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class TakeExam extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_exam);

        Spinner spinnerUserType=findViewById(R.id.spinnerSubjects);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.subject, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerUserType.setAdapter(adapter);

        Button Btn_submitSubject=findViewById(R.id.btnSubmitSubject);
        String subjectType=spinnerUserType.getSelectedItem().toString();
        TextView q1=findViewById(R.id.textQ1);
        TextView q2=findViewById(R.id.textQ2);
        TextView q3=findViewById(R.id.textQ3);
        RadioButton q1oA=findViewById(R.id.Q1OptionA);
        RadioButton q1oB=findViewById(R.id.Q1OptionB);

        RadioButton q2oA=findViewById(R.id.Q2OptionA);
        RadioButton q2oB=findViewById(R.id.Q2OptionB);

        RadioButton q3oA=findViewById(R.id.Q3OptionA);
        RadioButton q3oB=findViewById(R.id.Q3OptionB);
        Btn_submitSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(subjectType.matches("Geography")){
                    q1.setText("1. What is the capital of France?");
                    q1oA.setText("A. Paris");
                    q1oB.setText("B. London");

                    q2.setText("2. What is the capital of Japan?");
                    q2oA.setText("A. Tokyo");
                    q2oB.setText("B. Beijing");

                    q3.setText("3. What is the largest planet in our solar system?");
                    q3oA.setText("A. Earth");
                    q3oB.setText("B. Jupiter");
                } else if (subjectType.matches("Science")) {
                    q1.setText("1.In which among the following organ, “Bowman’s Capsule” is found?");
                    q1oA.setText("A. Liver");
                    q1oB.setText("B. Kidney");

                    q2.setText("2. In which organ RBC are selectively destroyed/ recycled by macrophages?");
                    q2oA.setText("A. Biometry");
                    q2oB.setText("B.Bionics");

                    q3.setText("3. Which among the following impurity in drinking water causes the “Bamboo Spine” disorder?");
                    q3oA.setText("A.Nitrate");
                    q3oB.setText("B.Fluorides");
                } else if (subjectType.matches("English")) {
                    q1.setText("1. They ______ her and trusted her for years");
                    q1oA.setText("A. know");
                    q1oB.setText("B. knew");

                    q2.setText("2. Every morning she ______ up early and gets ready for work.");
                    q2oA.setText("A. had woken");
                    q2oB.setText("B. wakes");

                    q3.setText("3. People ______ walk on grass.");
                    q3oA.setText("A. needn't");
                    q3oB.setText("B. mustn't");
                } else if (subjectType.matches("Maths")) {
                    q1.setText("1. 121 Divided by 11 is ");
                    q1oA.setText("A. 11");
                    q1oB.setText("B. 19");

                    q2.setText("2. 60 Times of 8 Equals to?");
                    q2oA.setText("A. 480");
                    q2oB.setText("B. 120");

                    q3.setText("3. Find the Missing Term in Multiples of 6 : 6, 12, 18, 24, _, 36, 42, _ 54, 60.");
                    q3oA.setText("A. 32, 45");
                    q3oB.setText("B.30, 48");
                }
            }
        });
        Button submit = findViewById(R.id.btnSubmitExam);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TakeExam.this, "Submitted", Toast.LENGTH_SHORT).show();
                Intent gotoStudentPage=new Intent(TakeExam.this,StudentsFuncs.class);
                startActivity(gotoStudentPage);
            }
        });
    }
}