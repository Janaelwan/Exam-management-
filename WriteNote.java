package com.example.newproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WriteNote extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_note);

        String note=((EditText)(findViewById(R.id.editTextNote))).getText().toString();
        Button sendNote=findViewById(R.id.btnSendNote);

        sendNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student s = new Student(0, "", "", "", 0);
                s.write_notes(note);
                Toast.makeText(WriteNote.this, "Note sent", Toast.LENGTH_SHORT).show();
            }
        });


    }
}