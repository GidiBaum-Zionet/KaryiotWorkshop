package com.example.calculator.controllers;

import com.example.calculator.algo.CalculatorAlgorithm;
import com.example.calculator.algo.CalculatorKey;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalculatorController {

    @FXML Label label;

    @FXML private Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    @FXML private Button buttonPlus, buttonMinus, buttonEqual, buttonClear;

    CalculatorAlgorithm algo = new CalculatorAlgorithm();

    public void initialize() {
        label.setText("Hello");

        button1.setOnAction(e -> press(CalculatorKey.KEY_1));
        button2.setOnAction(e -> press(CalculatorKey.KEY_2));
        button3.setOnAction(e -> press(CalculatorKey.KEY_3));
        button4.setOnAction(e -> press(CalculatorKey.KEY_4));
        button5.setOnAction(e -> press(CalculatorKey.KEY_5));
        button6.setOnAction(e -> press(CalculatorKey.KEY_6));
        button7.setOnAction(e -> press(CalculatorKey.KEY_7));
        button8.setOnAction(e -> press(CalculatorKey.KEY_8));
        button9.setOnAction(e -> press(CalculatorKey.KEY_9));
        button0.setOnAction(e -> press(CalculatorKey.KEY_0));

        buttonPlus.setOnAction(e -> press(CalculatorKey.KEY_PLUS));
        buttonMinus.setOnAction(e -> press(CalculatorKey.KEY_MINUS));
        buttonEqual.setOnAction(e -> press(CalculatorKey.KEY_EQUAL));
        buttonClear.setOnAction(e -> press(CalculatorKey.KEY_CLEAR));

    }

    private void press(CalculatorKey c) {
        label.setText(algo.set(c));
    }

}
