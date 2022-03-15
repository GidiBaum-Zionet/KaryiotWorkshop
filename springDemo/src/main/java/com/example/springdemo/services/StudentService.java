package com.example.springdemo.services;

import com.example.springdemo.entities.StudentEntity;
import com.example.springdemo.interfaces.IStudentService;
import com.example.springdemo.models.StudentModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.StreamSupport;

@Service
public class StudentService implements IStudentService {

    private final IStudentRepo repo;

    public StudentService(IStudentRepo repo){

        this.repo = repo;
    }

    @Override
    public StudentModel GenerateId(StudentModel student){

        var rnd = new Random();
        student.setId(rnd.nextInt(1000000));
        return student;
    }

    public List<StudentModel> getStudents(){
        var students = repo.findAll();

        return StreamSupport.stream(students.spliterator(),false)
                .map(StudentEntity::toModel)
                .toList();
    }
}
