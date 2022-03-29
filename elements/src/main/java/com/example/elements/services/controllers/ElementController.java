package com.example.elements.services.controllers;

import com.example.elements.models.ElementModel;
import com.example.elements.services.ElementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("api/")
public class ElementController {

    private final ElementService elementService;

    public ElementController(ElementService elementService){

        this.elementService = elementService;
    }

    @GetMapping(value = "/elements")
    public ResponseEntity<List<ElementModel>> getElements() {
        return new ResponseEntity<>(elementService.getElements(), HttpStatus.OK);
    }

}


