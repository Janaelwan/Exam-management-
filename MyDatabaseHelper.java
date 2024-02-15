package com.example.newproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class MyDatabaseHelper extends SQLiteOpenHelper {

    private final Context context;
    private static final String DATABASE_NAME = "ExamsManagement.db";
    private static final int DATABASE_VERSION = 1;

    MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE students (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "username TEXT, " +
                "password TEXT, " +
                "name TEXT, " +
                "grade INTEGER);";
        db.execSQL(query);

        query = "CREATE TABLE subjects (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, " +
                "grade INTEGER, " +
                "has_assignment INTEGER, " +
                "time TEXT);";
        db.execSQL(query);

        query = "CREATE TABLE teachers (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "subject_id INTEGER, " +
                "username TEXT, " +
                "password TEXT, " +
                "name TEXT, " +
                "salary REAL, " +
                "FOREIGN KEY (subject_id) REFERENCES subjects(id));";
        db.execSQL(query);

        query = "CREATE TABLE exams (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "subject_id INTEGER, " +
                "type TEXT, " +
                "mark REAL, " +
                "duration REAL, " +
                "start_date TEXT, " +
                "FOREIGN KEY (subject_id) REFERENCES subjects(id));";
        db.execSQL(query);

        query = "CREATE TABLE conducted_exams (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "student_id INTEGER, " +
                "subject_id INTEGER, " +
                "type TEXT, " +
                "grade REAL, " +
                "date TEXT, " +
                "FOREIGN KEY (student_id) REFERENCES students(id), " +
                "FOREIGN KEY (subject_id) REFERENCES subjects(id));";
        db.execSQL(query);

        db.execSQL("PRAGMA foreign_keys=ON;");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS students");
        db.execSQL("DROP TABLE IF EXISTS teachers");
        db.execSQL("DROP TABLE IF EXISTS exams");
        onCreate(db);
    }

    public User login(String type, String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = "username = ? AND password = ?";
        String[] selectionArgs = { username, password };

        Cursor cursor = db.query(type + "s",null,selection, selectionArgs,null,null,null);
        User user = null;
        if (cursor != null && cursor.moveToFirst()) {
            if(type.equals("student")) {
                user = new Student(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getInt(4));
            } else if(type.equals("teacher")) {
                user = new Teacher(
                        cursor.getInt(0),
                        cursor.getInt(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getDouble(5));
            }
        }
        db.close();
        return user;
    }

    public void addStudent(String username, String password, String name, int grade){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("username", username);
        cv.put("password", password);
        cv.put("name", name);
        cv.put("grade", grade);

        long result = db.insert("students",null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed To Add", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

    public void updateStudent(int id, String username, String password, String name, int grade){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("username", username);
        cv.put("password", password);
        cv.put("name", name);
        cv.put("grade", grade);

        long result = db.update("students", cv, "id=?", new String[]{String.valueOf(id)});
        if(result == -1){
            Toast.makeText(context, "Failed To Update", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

    public void deleteStudent(int id){
        SQLiteDatabase db = this.getWritableDatabase();

        long result = db.delete("students", "id=?", new String[]{String.valueOf(id)});
        if(result == -1){
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Deleted Successfully!", Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

    public List<Student> getAllStudents(){
        List<Student> students = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query("students",null,null,null,null,null,"name");
        while (cursor.moveToNext()){
            students.add(new Student(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getInt(4)));
        }
        db.close();
        return students;
    }

    public Student getStudent(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = "id = ?";
        String[] selectionArgs = { String.valueOf(id) };

        Cursor cursor = db.query("students",null,selection, selectionArgs,null,null,null);
        Student student = null;
        if (cursor != null && cursor.moveToFirst()) {
            student = new Student(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getInt(4));
        }
        db.close();
        return student;
    }

    public void addTeacher(int subject_id, String username, String password, String name, double salary){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("subject_id", subject_id);
        cv.put("username", username);
        cv.put("password", password);
        cv.put("name", name);
        cv.put("salary", salary);

        long result = db.insert("teachers",null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed To Add", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

    public void updateTeacher(int id, int subject_id, String username, String password, String name, double salary){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("subject_id", subject_id);
        cv.put("username", username);
        cv.put("password", password);
        cv.put("name", name);
        cv.put("salary", salary);

        long result = db.update("teachers", cv, "id=?", new String[]{String.valueOf(id)});
        if(result == -1){
            Toast.makeText(context, "Failed To Update", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

    public void deleteTeacher(int id){
        SQLiteDatabase db = this.getWritableDatabase();

        long result = db.delete("teachers", "id=?", new String[]{String.valueOf(id)});
        if(result == -1){
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Deleted Successfully!", Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

    public List<Teacher> getAllTeachers(){
        List<Teacher> teachers = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query("teachers",null,null,null,null,null,"name");
        while (cursor.moveToNext()){
            teachers.add(new Teacher(
                    cursor.getInt(0),
                    cursor.getInt(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getDouble(5)));
        }
        db.close();
        return teachers;
    }

    public Teacher getTeacher(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = "id = ?";
        String[] selectionArgs = { String.valueOf(id) };

        Cursor cursor = db.query("students",null,selection, selectionArgs,null,null,null);
        Teacher teacher = null;
        if (cursor != null && cursor.moveToFirst()) {
            teacher = new Teacher(
                    cursor.getInt(0),
                    cursor.getInt(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getDouble(5));
        }
        db.close();
        return teacher;
    }

    public void addExam(int subjectId, String type, double mark, double duration, String startDate){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("subject_id", subjectId);
        cv.put("type", type);
        cv.put("mark", mark);
        cv.put("duration", duration);
        cv.put("start_date", startDate);

        long result = db.insert("exams",null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed To Add", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

    public void updateExam(int id, int subjectId, String type, double mark, double duration, String startDate){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("subject_id", subjectId);
        cv.put("type", type);
        cv.put("mark", mark);
        cv.put("duration", duration);
        cv.put("start_date", startDate);

        long result = db.update("exams", cv, "id=?", new String[]{String.valueOf(id)});
        if(result == -1){
            Toast.makeText(context, "Failed To Update", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

    public Exam deleteExam(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = "id = ?";
        String[] selectionArgs = { String.valueOf(id) };

        Cursor cursor = db.query("exams",null,selection, selectionArgs,null,null,null);
        Exam exam = null;
        if (cursor != null && cursor.moveToFirst()) {
            exam = new Exam(
                    cursor.getInt(0),
                    cursor.getInt(1),
                    cursor.getString(2),
                    cursor.getDouble(3),
                    cursor.getDouble(4),
                    cursor.getString(5));
        }

        db = this.getWritableDatabase();

        long result = db.delete("exams", selection, selectionArgs);
        if(result == -1){
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Deleted Successfully!", Toast.LENGTH_SHORT).show();
        }
        db.close();
        return exam;
    }

    public Exam getExam(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = "id = ?";
        String[] selectionArgs = { String.valueOf(id) };

        Cursor cursor = db.query("exams",null,selection, selectionArgs,null,null,null);
        Exam exam = null;
        if (cursor != null && cursor.moveToFirst()) {
            exam = new Exam(
                    cursor.getInt(0),
                    cursor.getInt(1),
                    cursor.getString(2),
                    cursor.getDouble(3),
                    cursor.getDouble(4),
                    cursor.getString(5));
        }
        db.close();
        return exam;
    }

    public List<Exam> getGradeExams(int grade) {
        SQLiteDatabase db = this.getWritableDatabase();
        List<Exam> exams = new ArrayList<>();

        String[] projection = {"exams.*"};
        String tables = "subjects INNER JOIN exams ON subjects.id = exams.subject_id";

        String selection = "subjects.grade = ?";
        String[] selectionArgs = {String.valueOf(grade)};

        String query = "SELECT " + String.join(", ", projection) + " FROM " + tables + " WHERE " + selection + ";";
        Cursor cursor = db.rawQuery(query, selectionArgs);

        while (cursor.moveToNext()){
            exams.add(new Exam(
                    cursor.getInt(0),
                    cursor.getInt(1),
                    cursor.getString(2),
                    cursor.getDouble(3),
                    cursor.getDouble(4),
                    cursor.getString(5)));
        }
        db.close();
        return exams;
    }

    public void addConductedExam(int studentId, int subjectId, String type, double grade, String date){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("student_id", studentId);
        cv.put("subject_id", subjectId);
        cv.put("type", type);
        cv.put("grade", grade);
        cv.put("date", date);

        long result = db.insert("conducted_exams",null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed To Add", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

    public List<ConductedExam> getAllConductedExams(){
        List<ConductedExam> conductedExams = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query("conducted_exams",null,null,null,null,null,"name");
        while (cursor.moveToNext()){
            conductedExams.add(new ConductedExam(
                    cursor.getInt(0),
                    cursor.getInt(1),
                    cursor.getInt(2),
                    cursor.getString(3),
                    cursor.getDouble(4),
                    cursor.getString(5)));
        }
        db.close();
        return conductedExams;
    }

    public List<ConductedExam> getStudentConductedExams(int studentId) {
        SQLiteDatabase db = this.getWritableDatabase();
        List<ConductedExam> conductedExams = new ArrayList<>();

        String selection = "student_id = ?";
        String[] selectionArgs = { String.valueOf(studentId) };

        Cursor cursor = db.query("conducted_exams",null,selection, selectionArgs,null,null,null);

        while (cursor.moveToNext()){
            conductedExams.add(new ConductedExam(
                    cursor.getInt(0),
                    cursor.getInt(1),
                    cursor.getInt(2),
                    cursor.getString(3),
                    cursor.getDouble(4),
                    cursor.getString(5)));
        }
        db.close();
        return conductedExams;
    }

    public List<ConductedExam> getStudentExamsAtSubject(int studentId, int subjectId) {
        SQLiteDatabase db = this.getWritableDatabase();
        List<ConductedExam> conductedExams = new ArrayList<>();

        String[] projection = {"conducted_exams.*"};
        String tables = "students INNER JOIN conducted_exams ON students.id = conducted_exams.student_id " +
                "INNER JOIN subjects ON subjects.id = conducted_exams.subject_id";

        String selection = "students.id = ? AND subjects.id = ?";
        String[] selectionArgs = {String.valueOf(studentId), String.valueOf(subjectId)};

        String query = "SELECT " + String.join(", ", projection) + " FROM " + tables + " WHERE " + selection + ";";
        Cursor cursor = db.rawQuery(query, selectionArgs);

        while (cursor.moveToNext()){
            conductedExams.add(new ConductedExam(
                    cursor.getInt(0),
                    cursor.getInt(1),
                    cursor.getInt(2),
                    cursor.getString(3),
                    cursor.getDouble(4),
                    cursor.getString(5)));
        }
        db.close();
        return conductedExams;
    }

    public void addSubject(String name, int grade, boolean hasAssignment, String time){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("name", name);
        cv.put("grade", grade);
        cv.put("has_assignment", hasAssignment);
        cv.put("time", time);

        long result = db.insert("subjects",null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed To Add", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

    public void updateSubject(int id, String name, int grade, boolean hasAssignment, String time){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("name", name);
        cv.put("grade", grade);
        cv.put("has_assignment", hasAssignment);
        cv.put("time", time);

        long result = db.update("subjects", cv, "id=?", new String[]{String.valueOf(id)});
        if(result == -1){
            Toast.makeText(context, "Failed To Update", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

    public Subject getSubject(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = "id = ?";
        String[] selectionArgs = { String.valueOf(id) };

        Cursor cursor = db.query("subjects",null,selection, selectionArgs,null,null,null);
        Subject subject = null;
        if (cursor != null && cursor.moveToFirst()) {
            subject = new Subject(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getInt(2),
                    Boolean.parseBoolean(cursor.getString(3)),
                    cursor.getString(4));
        }
        db.close();
        return subject;
    }
}
