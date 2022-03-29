package com.example.elements.services;

import com.example.elements.entities.ElementEntity;
import com.example.elements.models.ElementModel;
import com.example.elements.repositories.ElementRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class ElementService {

    private final ElementRepository elementRepository;

    public ElementService(ElementRepository elementRepository){

        this.elementRepository = elementRepository;
    }

    public List<ElementModel> getElements() {

        var set = elementRepository.findAll();

        return StreamSupport.stream(set.spliterator(), false)
                .map(ElementEntity::toModel)
                .toList();
    }

}
