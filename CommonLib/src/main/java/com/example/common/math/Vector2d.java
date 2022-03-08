package com.example.common.math;

public class Vector2d {

    public double x;
    public double y;

    public Vector2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Vector2d vec(double x, double y) {
        return new Vector2d(x, y);
    }

    public static Vector2d op_plus(Vector2d a, Vector2d b) {
        return vec(a.x + b.x, a.y + b.y);
    }

    public static Vector2d op_minus(Vector2d a, Vector2d b) {
        return vec(a.x - b.x, a.y - b.y);
    }

    public Vector2d add(Vector2d b) {
        return vec(x + b.x, y + b.y);
    }

    public Vector2d subtract(Vector2d b) {
        return vec(x - b.x, y - b.y);
    }

    public Vector2d multiply(double s) {
        return vec(x * s, y * s);
    }

}
