module com.example.calculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.calculator to javafx.fxml;
    exports com.example.calculator;
    exports com.example.calculator.controllers;
    opens com.example.calculator.controllers to javafx.fxml;
    exports com.example.calculator.algo;
    opens com.example.calculator.algo to javafx.fxml;
}
