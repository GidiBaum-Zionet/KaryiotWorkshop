package com.example.elements.services;

import com.example.elements.entities.ElementCountEntity;
import com.example.elements.entities.ElementEntity;
import com.example.elements.entities.MaterialEntity;
import com.example.elements.models.ElementModel;
import com.example.elements.models.MaterialModel;
import com.example.elements.repositories.ElementCountRepository;
import com.example.elements.repositories.ElementRepository;
import com.example.elements.repositories.MaterialRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.StreamSupport;

@Service
public class ElementService {

    private final ElementRepository elementRepository;
    private final MaterialRepository materialRepository;
    private final ElementCountRepository elementCountRepository;

    final Pattern pattern = Pattern.compile("(?<Symbol>[A-Z][a-z]*)(?<Number>\\d*)");

    public ElementService(
            ElementRepository elementRepository,
            MaterialRepository materialRepository,
            ElementCountRepository elementCountRepository){

        this.elementRepository = elementRepository;
        this.materialRepository = materialRepository;
        this.elementCountRepository = elementCountRepository;
    }

    public List<ElementModel> getElements() {

        var set = elementRepository.findAll();

        return StreamSupport.stream(set.spliterator(), false)
                .map(ElementEntity::toModel)
                .toList();
    }


    public ElementModel getElement(String symbol) {
        return elementRepository
                .findBySymbolEquals(symbol)
                .toModel();
    }


    public MaterialModel addMaterial(String formula, String name) {

        var material = new MaterialEntity();
        material.setFormula(formula);
        material.setName(name);

        var composition = parse(formula);

        var elementCounts = material.getElements();
        elementCounts.addAll(composition);

        var weight = elementCounts
                .stream()
                .mapToDouble(e -> e.getNumber() * e.getElement().getMass())
                .sum();

        material.setMolecularWeight(weight);

        materialRepository.save(material);

        for (var item: composition) {
            item.setMaterial(material);
            elementCountRepository.save(item);
        }

        return material.toModel();
    }

    public List<ElementCountEntity> parse(String formula) {

        var list = new ArrayList<ElementCountEntity>();

        var matcher = pattern.matcher(formula);

        while (matcher.find()) {

            var symbol = matcher.group("Symbol");
            var number = 1;
            var numText = matcher.group("Number");
            if (!numText.isEmpty()) {
                number = Integer.parseInt(numText);
            }

            var element = elementRepository.findBySymbolEquals(symbol);

            var part = new ElementCountEntity();
            part.setElement(element);
            part.setNumber(number);
            list.add(part);
        }

        return list;
    }


    public Resource getElementFile(){
        var elements = getElements();

        var Obj = new ObjectMapper();

        try {

            var jsonStr = Obj.writeValueAsString(elements);

            return new ByteArrayResource(jsonStr.getBytes(), "elementTable.json");
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
