package com.example.elements.repositories;

import com.example.elements.entities.MaterialEntity;
import org.springframework.data.repository.CrudRepository;

public interface MaterialRepository extends CrudRepository<MaterialEntity, Long> {
    MaterialEntity findByName(String name);
    MaterialEntity findByFormula(String formula);
}
