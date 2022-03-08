package com.example.calculator.algo;

public enum CalculatorKey {

    KEY_1('1'),
    KEY_2('2'),
    KEY_3('3'),
    KEY_4('4'),
    KEY_5('5'),
    KEY_6('6'),
    KEY_7('7'),
    KEY_8('8'),
    KEY_9('9'),
    KEY_0('0'),
    KEY_PLUS('+'),
    KEY_MINUS('-'),
    KEY_EQUAL('='),
    KEY_CLEAR('c');

    private final Character c;

    CalculatorKey(Character c) {
        this.c = c;
    }

    public Character getValue() {
        return c;
    }
}
