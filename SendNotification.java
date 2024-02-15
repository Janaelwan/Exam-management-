package com.example.newproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendNotification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_notification);

        MyDatabaseHelper myDB= new MyDatabaseHelper(this);

        Button sms=findViewById(R.id.sendBySMS_Btn);
        Button email=findViewById(R.id.sendByEmail_Btn);
        Button whats=findViewById(R.id.sendByWhats_Btn);

        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id=Integer.parseInt(((EditText)(findViewById(R.id.editTxtID))).getText().toString());
                Student student = myDB.getStudent(id);
                Teacher t=new Teacher(0,0,"","","",0);
                t.addCommand(new SMSNotification(student,"Grads Published"));
                t.executeCommands(SendNotification.this);
            }
        });

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id=Integer.parseInt(((EditText)(findViewById(R.id.editTxtID))).getText().toString());
                Student student = myDB.getStudent(id);
                Teacher t=new Teacher(0,0,"","","",0);
                t.addCommand(new EmailNotification(student,"Grads Published"));
                t.executeCommands(SendNotification.this);
            }
        });

        whats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id=Integer.parseInt(((EditText)(findViewById(R.id.editTxtID))).getText().toString());
                Student student = myDB.getStudent(id);
                Teacher t=new Teacher(0,0,"","","",0);
                t.addCommand(new WhatsAppNotification(student,"Grads Published"));
                t.executeCommands(SendNotification.this);
            }
        });

    }
}