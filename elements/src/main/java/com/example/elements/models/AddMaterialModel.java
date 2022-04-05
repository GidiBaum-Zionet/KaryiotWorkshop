package com.example.elements.models;

import com.example.elements.entities.MaterialEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddMaterialModel {
    private String name;
    private String formula;

    public MaterialEntity toEntity(){
        var entity = new MaterialEntity();

        entity.setName(name);
        entity.setFormula(formula);

        return entity;
    }
}
