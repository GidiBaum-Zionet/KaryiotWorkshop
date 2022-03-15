package com.example.springdemo.interfaces;

import com.example.springdemo.models.StudentModel;

import java.util.List;

public interface IStudentService {
    List<StudentModel> getStudents();
    StudentModel GenerateId(StudentModel student);
}
