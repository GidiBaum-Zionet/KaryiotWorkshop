package com.example.springdemo.controllers;

import com.example.springdemo.interfaces.IStudentService;
import com.example.springdemo.models.StudentModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/student")
public class StudentController {

    private final IStudentService studentService;

    public StudentController(IStudentService studentService){

        this.studentService = studentService;
    }

    @GetMapping("/all")
     public ResponseEntity<List<StudentModel>> getStudents(){

        var students = studentService.getStudents();

        return ResponseEntity.ok(students);
    }

    @GetMapping()
    public ResponseEntity<StudentModel> getStudent(){

        var student = StudentModel
                .builder()
                .Id(123123)
                .Name("Moshe Gross")
                .Subject("Engineering")
                .build();

        return ResponseEntity.ok(student);
    }

    @PostMapping()
    public ResponseEntity<StudentModel> postStudent(@RequestBody StudentModel student){

        var student1 = studentService.GenerateId(student);

        return ResponseEntity.ok(student1);
    }

}
