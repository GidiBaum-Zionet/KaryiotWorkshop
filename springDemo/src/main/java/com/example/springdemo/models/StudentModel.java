package com.example.springdemo.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentModel {

    private String Name;
    private Integer Id;
    private String Subject;
}
