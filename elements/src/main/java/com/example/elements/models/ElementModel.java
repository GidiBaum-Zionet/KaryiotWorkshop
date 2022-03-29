package com.example.elements.models;

import com.example.elements.entities.ElementEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ElementModel {

    private String symbol;
    private String name;
    private int z;
    private double mass;
    private Integer period;
    private Integer group;
    private String classes;

    public ElementEntity toEntity(){
        var entity = new ElementEntity();

        entity.setSymbol(symbol);
        entity.setName(name);
        entity.setZ(z);
        entity.setMass(mass);
        entity.setPeriod(period);
        entity.setGroup(group);
        entity.setClasses(classes);

        return entity;
    }

    @Override
    public String toString() {
        return String.format("%d %s (%s)",z, name, symbol);
    }
}
