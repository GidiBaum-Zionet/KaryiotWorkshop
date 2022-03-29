package com.example.elements.services.controllers;

import com.example.elements.services.ICalcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

@Scope(value = WebApplicationContext.SCOPE_SESSION)
@RestController()
@RequestMapping("api/demo/")
public class DemoController {

    private final ICalcService calcService;
    Logger logger = LoggerFactory.getLogger(DemoController.class);

    //DemoController(@Qualifier("multi") ICalcService multi1Service){
    DemoController(@Qualifier("beanDemo") ICalcService calcService){

        logger.info("DemoController::ctor");
        this.calcService = calcService;
    }

    @GetMapping(value ="/hello")
    public ResponseEntity<String> getHello() {

        var z = calcService.calc(1,2);
        return new ResponseEntity<>("Hi 1234", HttpStatus.OK);
    }
}
