package com.example.elements.repositories;

import com.example.elements.entities.ElementCountEntity;
import org.springframework.data.repository.CrudRepository;

public interface ElementCountRepository extends CrudRepository<ElementCountEntity, Long> {
}
