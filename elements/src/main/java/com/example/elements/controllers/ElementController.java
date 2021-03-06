package com.example.elements.controllers;

import com.example.elements.entities.ElementCountEntity;
import com.example.elements.models.AddMaterialModel;
import com.example.elements.models.ElementModel;
import com.example.elements.models.MaterialModel;
import com.example.elements.services.ElementService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.Thread.sleep;

@RestController
@RequestMapping("api/")
@SecurityRequirement(name = "bearerAuth")
public class ElementController {

    private final ElementService elementService;

    public ElementController(ElementService elementService){

        this.elementService = elementService;
    }

    @GetMapping(value = "/elements")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<ElementModel>> getElements() {
        return new ResponseEntity<>(elementService.getElements(), HttpStatus.OK);
    }

    @GetMapping(value = "/element")
    @Cacheable("element")
    public ElementModel getElement(@RequestParam("symbol") String symbol) throws InterruptedException {

        sleep(500);

        return elementService.getElement(symbol);
    }


    @GetMapping(value = "/element/file", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Resource> getElementFile() {
        var res =  elementService.getElementFile();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + "ElementTable.json" + "\"")
                .body(res);
    }


    @PostMapping(value = "/material")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<MaterialModel> parseFormula(@RequestBody AddMaterialModel model) {
        var material = elementService.addMaterial(model.getFormula(), model.getName());
        return new ResponseEntity<>(material, HttpStatus.OK);
    }
}


