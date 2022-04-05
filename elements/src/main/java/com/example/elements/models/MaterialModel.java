package com.example.elements.models;

import com.example.elements.entities.MaterialEntity;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MaterialModel {
    private String name;
    private String formula;
    private double molecularWeight;
    private List<ElementCountModel> elementCounts;

    public MaterialEntity toEntity(){
        var entity = new MaterialEntity();

        entity.setName(name);
        entity.setFormula(formula);
        entity.setMolecularWeight(molecularWeight);

        return entity;
    }
}
