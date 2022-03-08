package com.example.common.math;

public class LinearAlgebra {

    public static Vector2d solve(Matrix2 a, Vector2d b){

        var det = a.getDeterminant();
        if (det == 0) return null;

        return Matrix2.mat(a.a22, -a.a21, -a.a12, a.a11)
                .multiply(b)
                .multiply(1/det);
    }
}
