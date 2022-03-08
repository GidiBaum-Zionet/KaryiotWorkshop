package com.example.common.math;

public class Matrix2 {

    public double a11, a12, a21, a22;

    Matrix2() {

    }

    Matrix2(double a11, double a12, double a21, double a22) {
        this.a11 = a11;
        this.a12 = a12;
        this.a21 = a21;
        this.a22 = a22;
    }

    public static Matrix2 mat(double a11, double a12, double a21, double a22) {
        return new Matrix2(a11, a12, a21, a22);
    }

    public double getDeterminant() {
        return a11 * a22 - a21 * a12;
    }

    public Vector2d multiply(Vector2d v) {
        return Vector2d.vec(a11 * v.x + a12 * v.y, a21 * v.x + a22 * v.y);
    }

    public Matrix2 multiply(double s) {
        return mat(a11 * s, a12 * s, a21 * s, a22 * s);
    }

}
