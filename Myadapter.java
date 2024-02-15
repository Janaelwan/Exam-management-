package com.example.newproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Myadapter extends RecyclerView.Adapter<Myviewholder> {

    Context context;
    List<ConductedExam> items;
    MyDatabaseHelper myDB;

    public Myadapter(Context context, List<ConductedExam> items, MyDatabaseHelper myDB) {
        this.context = context;
        this.items = items;
        this.myDB = myDB;
    }

    @NonNull
    @Override
    public Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Myviewholder(LayoutInflater.from(context).inflate(R.layout.imageview,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Myviewholder holder, int position) {
        Subject subject = myDB.getSubject(items.get(position).getSubject_id());
        Student student = myDB.getStudent(items.get(position).getStudent_id());

        holder.nameview.setText(student.getName());
        holder.emailview.setText(subject.getName());
        holder.gradeview.setText(String.valueOf(items.get(position).getGrade()));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
