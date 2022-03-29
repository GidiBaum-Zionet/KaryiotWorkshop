package com.example.elements.services;

import com.example.elements.entities.ElementEntity;
import com.example.elements.models.ElementModel;
import com.example.elements.repositories.ElementRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;

import static java.lang.System.out;

@Service
public class DataLoader {

    private final ElementRepository elementRepository;
    static Logger log = LoggerFactory.getLogger(DataLoader.class);

    public DataLoader(ElementRepository elementRepository){

        this.elementRepository = elementRepository;
    }

    List<ElementModel> loadInitData(String jsonFile) throws IOException {

        var mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        var typeReference = new TypeReference<List<ElementEntity>>(){};
        var inputStream = DataLoader.class.getResourceAsStream(jsonFile);

        try {
            var elements = mapper.readValue(inputStream, typeReference);
            out.println("Element Loaded!");
            return elements.stream().sequential().map(ElementEntity::toModel).toList();
        } catch (IOException e) {
            out.println("Unable to load elements: " + e.getMessage());
            throw e;
        }
    }

    @PostConstruct
    public void Load() throws IOException {

        var count = elementRepository.count();

        if (count != 0) {
            log.debug("Elements found: " + count);
        } else {
            var elementList = loadInitData("/data/TableOfElements.json");
            var entities = elementList.stream().map(ElementModel::toEntity).toList();
            elementRepository.saveAll(entities);

            log.debug("Elements saved: " + entities.size());
        }
    }

}
