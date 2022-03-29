package com.example.elements.services;

import org.springframework.stereotype.Service;

@Service("multi")
public class MultiService implements ICalcService {

    @Override
    public int calc(int x, int y) {
        return x*y;
    }
}
