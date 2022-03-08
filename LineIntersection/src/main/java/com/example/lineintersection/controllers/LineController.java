package com.example.lineintersection.controllers;

import com.example.common.math.LineSegment;
import com.example.common.math.LineSegmentIntersection;
import com.example.common.math.Vector2d;
import com.example.lineintersection.views.ResizableCanvas;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class LineController implements Initializable {

    @FXML
    Slider slider1;

    @FXML
    Slider slider2;

    @FXML
    public ResizableCanvas canvas;

    public GraphicsContext gc;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        gc = canvas.getGraphicsContext2D();

        canvas.widthProperty().addListener(observable -> update());
        canvas.heightProperty().addListener(observable -> update());

        slider1.valueProperty().addListener(observable -> {
            update();
        });
        slider2.valueProperty().addListener(observable -> {
            update();
        });

        update();
    }

    void update() {
        clear();

        gc.setFill(Color.BLUE);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(2);

        var line1X = slider1.getValue();
        var line2X = slider2.getValue();

        var p0 = new Vector2d(-0.5, -0.9);
        var p1 = new Vector2d(line1X, 0.9);
        var p2 = new Vector2d(0.5, -0.9);
        var p3 = new Vector2d(line2X, 0.9);

        var pix0 = toCanvasPixel(p0);
        var pix1 = toCanvasPixel(p1);
        var pix2 = toCanvasPixel(p2);
        var pix3 = toCanvasPixel(p3);

        drawPoint(pix0, 9);
        drawPoint(pix1, 9);

        drawLine(pix0, pix1);

        drawPoint(pix2, 9);
        drawPoint(pix3, 9);

        drawLine(pix2, pix3);

        var segment0 = new LineSegment(p0, p1);
        var segment1 = new LineSegment(p2, p3);

        var intersectionPoint = LineSegmentIntersection.intersect(segment0, segment1);

        if (intersectionPoint != null) {
            intersectionPoint = toCanvasPixel(intersectionPoint);
            gc.setFill(Color.RED);
            drawPoint(intersectionPoint, 13);
        }

    }

    void clear() {
        gc.setFill(Color.SNOW);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    void drawPoint(Vector2d v, double size) {
        gc.fillOval(v.x - size / 2, v.y - size / 2, size, size);
    }

    void drawLine(Vector2d a, Vector2d b) {
        gc.strokeLine(a.x, a.y, b.x, b.y);
    }

    Vector2d toCanvasPixel(Vector2d v) {
        return new Vector2d(
                0.5 * (v.x + 1) * canvas.getWidth(),
                0.5 * (1 - v.y) * canvas.getHeight());
    }

}
