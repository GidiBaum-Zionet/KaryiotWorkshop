package com.example.springdemo.services;

import com.example.springdemo.interfaces.IStudentService;
import com.example.springdemo.models.StudentModel;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class StudentService implements IStudentService {

    public StudentService(){

    }

    @Override
    public StudentModel GenerateId(StudentModel student){

        var rnd = new Random();
        student.setId(rnd.nextInt(1000000));
        return student;
    }
}
