package com.example.elements.entities;

import com.example.elements.models.ElementModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "element_count")
public class ElementCountEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long pid;

    private int number;

    @OneToOne
//    @JoinColumn(name = "element_pid")
    ElementEntity element;

    @ManyToOne
//    @JoinColumn(name = "material_pid")
    MaterialEntity material;

}
