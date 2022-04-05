package com.example.elements;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ElementsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElementsApplication.class, args);
    }

}
