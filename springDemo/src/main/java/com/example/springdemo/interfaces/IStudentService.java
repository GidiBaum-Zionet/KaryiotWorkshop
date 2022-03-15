package com.example.springdemo.interfaces;

import com.example.springdemo.models.StudentModel;

public interface IStudentService {
    StudentModel GenerateId(StudentModel student);
}
