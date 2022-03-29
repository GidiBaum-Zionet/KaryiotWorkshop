package com.example.elements.repositories;

import com.example.elements.entities.ElementEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface ElementRepository extends CrudRepository<ElementEntity, Long> {

    ElementEntity findByName(String name);

    @Query("SELECT e FROM ElementEntity e WHERE e.classes like %:elementClass%")
    Collection<ElementEntity> findAllMetals(String elementClass);

}
