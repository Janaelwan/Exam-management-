package com.example.newproject;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Myviewholder extends RecyclerView.ViewHolder {
    TextView nameview,emailview, gradeview;
    public Myviewholder(@NonNull View itemView) {
        super(itemView);
        gradeview=itemView.findViewById(R.id.gradeview);
        nameview=itemView.findViewById(R.id.nameview);
        emailview=itemView.findViewById(R.id.nameview2);
    }
}
