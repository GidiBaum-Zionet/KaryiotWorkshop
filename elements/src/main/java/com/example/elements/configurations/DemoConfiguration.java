package com.example.elements.configurations;

import com.example.elements.services.AddService;
import com.example.elements.services.ICalcService;
import com.example.elements.services.MultiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoConfiguration {

    @Value("${calculationType}")
    String calculationType;

    @Bean("beanDemo")
    public ICalcService getDemoService(){

        switch (calculationType){
            case "add":
                return new AddService();
            case "multi":
                return new MultiService();
        }

        throw new RuntimeException("Calculation not implemented");
    }
}
