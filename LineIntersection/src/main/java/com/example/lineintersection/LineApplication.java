package com.example.lineintersection;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.io.IOException;

public class LineApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        var fxmlLoader = new FXMLLoader(LineApplication.class.getResource("line-view.fxml"));
        var scene = new Scene(fxmlLoader.load(), 600, 600);

        stage.setTitle("Line");
        stage.setScene(scene);
        stage.show();

        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ESCAPE)
                Platform.exit();
        });

    }

    public static void main(String[] args) {
        launch();
    }
}
