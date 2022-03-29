package com.example.elements.entities;

import com.example.elements.models.ElementModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Elements")
public class ElementEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long pid;

    private String symbol;
    private String name;
    private int z;

    @Column(nullable = true)
    private Integer period;

    @Column(name = "grp", nullable = true)
    private Integer group;

    private double mass;

    @Column(nullable = true)
    private String classes;

    @Override
        public String toString() {
        return String.format("%d %s (%s)",z, name, symbol);
    }

    public ElementModel toModel(){
        return ElementModel
                .builder()
                .symbol(symbol)
                .name(name)
                .z(z)
                .mass(mass)
                .group(group)
                .period(period)
                .classes(classes)
                .build();
    }

}
