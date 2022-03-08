package com.example.calculator.algo;

public class CalculatorAlgorithm {

    String memory;
    String current;
    CalculatorKey operation;

    public CalculatorAlgorithm(){
        memory = "";
        current = "";
        operation = null;
    }

    public void clear(){

        memory = "";
        current = "";
        operation = null;
    }


    public String set(CalculatorKey c){

        switch (c){
            case KEY_1:
            case KEY_2:
            case KEY_3:
            case KEY_4:
            case KEY_5:
            case KEY_6:
            case KEY_7:
            case KEY_8:
            case KEY_9:
            case KEY_0:
                current += c.getValue();
                return current;

            case KEY_PLUS:
            case KEY_MINUS:
                memory = current;
                operation = c;
                current = "";
                return current;

            case KEY_EQUAL:

                switch (operation){
                    case KEY_PLUS:{
                        var x = Float.parseFloat(memory);
                        var y = Float.parseFloat(current);
                        current = Float.toString(x+y);
                        memory = "";
                        return current;
                    }

                    case KEY_MINUS:{
                        var x = Float.parseFloat(memory);
                        var y = Float.parseFloat(current);
                        current = Float.toString(x-y);
                        memory = "";
                        return current;
                    }

                    default:
                        return "Error";
                }

            case KEY_CLEAR:
                clear();
                return current;

            default:
                return "Error";
        }
    }
}
