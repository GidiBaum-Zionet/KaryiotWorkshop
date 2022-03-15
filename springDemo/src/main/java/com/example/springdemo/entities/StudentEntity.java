package com.example.springdemo.entities;


import com.example.springdemo.models.StudentModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class StudentEntity {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long pid;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private String subject;

    public StudentModel toModel(){
        return StudentModel.builder()
                .Id(id)
                .Name(name)
                .Subject(subject)
                .build();
    }
}
