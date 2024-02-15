package com.example.newproject;

import android.content.Context;

public class WhatsAppNotification implements Command{

    private Student std;
    private String message;
    public WhatsAppNotification(Student std, String message)
    {
        this.message = message;
        this.std = std;
    }
    @Override
    public void execute(Context context) {
        std.sendNotification(message, context);
    }
}