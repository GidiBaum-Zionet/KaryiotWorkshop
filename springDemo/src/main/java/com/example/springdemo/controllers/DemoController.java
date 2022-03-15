package com.example.springdemo.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("api/demo/")
public class DemoController {

    @GetMapping("/hello")
    public String getHello(){
        return "Hello Spring";
    }

    @GetMapping("/hello/name")
    public String getHelloName(String name){
        return "Hello Spring " + name;
    }

}
