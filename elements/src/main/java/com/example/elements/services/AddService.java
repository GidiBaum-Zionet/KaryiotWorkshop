package com.example.elements.services;

import org.springframework.stereotype.Service;

@Service
public class AddService implements ICalcService {

    @Override
    public int calc(int x, int y){
        return x+y;
    }
}
