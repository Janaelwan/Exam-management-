package com.example.newproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button Btn_logIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyDatabaseHelper myDB = new MyDatabaseHelper(this);

        Spinner spinnerUserType=findViewById(R.id.spinnerUsertype);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.user_type, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerUserType.setAdapter(adapter);

        Btn_logIn= findViewById(R.id.buttonLogin);

        Btn_logIn.setOnClickListener(view -> {
            String username = ((EditText)(findViewById(R.id.editTextusername))).getText().toString();
            String password = ((EditText)(findViewById(R.id.editTextpassword))).getText().toString();
            String logInType=spinnerUserType.getSelectedItem().toString();
            if(logInType.matches("Student")){
                Student student = new Student(0, username, password, "", 0);
                student = (Student) student.login(myDB);
                if(student != null) {
                    Intent gotoStudentPage=new Intent(MainActivity.this,StudentsFuncs.class);
                    startActivity(gotoStudentPage);
                } else
                    Toast.makeText(MainActivity.this, "Wrong Credentials", Toast.LENGTH_SHORT).show();
            } else if (logInType.matches("Teacher")) {
                Teacher teacher = new Teacher(0, 0, username, password, "", 0);
                teacher = (Teacher) teacher.login(myDB);
                if(teacher != null) {
                    Intent gotoStudentPage=new Intent(MainActivity.this,TeacherFuncs.class);
                    startActivity(gotoStudentPage);
                } else
                    Toast.makeText(MainActivity.this, "Wrong Credentials", Toast.LENGTH_SHORT).show();
            } else if (logInType.matches("Principal")) {
                Principal principal = Principal.getInstance();
                principal = (Principal) principal.login(username, password);
                if(principal != null) {
                    Intent gotoStudentPage=new Intent(MainActivity.this,ThePrincipal.class);
                    startActivity(gotoStudentPage);
                } else
                    Toast.makeText(MainActivity.this, "Wrong Credentials", Toast.LENGTH_SHORT).show();
            }
        });
    }
}