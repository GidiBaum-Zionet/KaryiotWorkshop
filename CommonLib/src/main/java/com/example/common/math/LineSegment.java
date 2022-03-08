package com.example.common.math;

import static com.example.common.math.Vector2d.op_minus;

public class LineSegment {
    public Vector2d p0;
    public Vector2d p1;

    public LineSegment(Vector2d p0, Vector2d p1){

        this.p0 = p0;
        this.p1 = p1;
    }

    public Vector2d getPoint(double t){
        // p0 + (p1-p0)*t
        return p0.add(( op_minus(p1, p0)).multiply(t));
    }
}
