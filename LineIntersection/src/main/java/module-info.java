module com.example.lineintersection {
    requires javafx.controls;
    requires javafx.fxml;
    requires CommonLib;


    opens com.example.lineintersection to javafx.fxml;
    exports com.example.lineintersection;
    exports com.example.lineintersection.views;
    opens com.example.lineintersection.views to javafx.fxml;
    exports com.example.lineintersection.controllers;
    opens com.example.lineintersection.controllers to javafx.fxml;
}
