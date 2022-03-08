package com.example.common.math;

import static com.example.common.math.Matrix2.*;
import static com.example.common.math.Vector2d.*;

public class LineSegmentIntersection {

    public static Vector2d intersect(LineSegment l0, LineSegment l1) {

        var p10 = op_minus(l0.p1, l0.p0);
        var q10 = op_minus(l1.p1, l1.p0);
        var q0p0 = op_minus(l1.p0, l0.p0);

        var mat = mat(p10.x, q10.x, p10.y, q10.y);

        var t = LinearAlgebra.solve(mat, q0p0);

        if (t == null) return null;

        var l = t.x;
        if (l < 0 || l > 1) return null;

        return l0.getPoint(l);
    }
}
