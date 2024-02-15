package com.example.newproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DeleteStudent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_student);

        Button deleteButton = findViewById(R.id.ActiondeleteStudent_Btn);
        MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(this);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(((EditText) (findViewById(R.id.editTXTIDS))).getText().toString());

                Principal p = Principal.getInstance();
                p.delete_student(id,myDatabaseHelper);
            }
        });
    }
}