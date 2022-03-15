package com.example.springdemo.services;

import com.example.springdemo.entities.StudentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepo extends CrudRepository<StudentEntity, Long> {

//    StudentEntity[] ge
}
