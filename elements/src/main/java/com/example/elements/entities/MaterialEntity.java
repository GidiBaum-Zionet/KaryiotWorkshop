package com.example.elements.entities;

import com.example.elements.models.MaterialModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "materials")
public class MaterialEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long pid;

    private String formula;
    private String name;
    private double molecularWeight;

    @OneToMany(mappedBy = "material")
    private Set<ElementCountEntity> elements = new HashSet<>();

    @Override
    public String toString() {
        return String.format("%s (%s)", name, formula);
    }

    public MaterialModel toModel(){
        return MaterialModel.builder()
                .name(name)
                .formula(formula)
                .molecularWeight(molecularWeight)
                .elementCounts(new ArrayList<>())
                .build();
    }

}
