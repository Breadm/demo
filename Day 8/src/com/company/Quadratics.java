package com.company;

public class Quadratics {
    public Double solution1(Number a, Number b, Number c) {
        double A = a.doubleValue(); double B = b.doubleValue(); double C = c.doubleValue();
        double D = B*B-4*A*C;
        if (D < 0)
            return null;
        else
            return (-B+Math.sqrt(D))/(2*A);
    }

    public Double solution2(Number a, Number b, Number c) {
        double A = a.doubleValue(); double B = b.doubleValue(); double C = c.doubleValue();
        double D = B*B-4*A*C;
        if (D < 0)
            return null;
        else
            return (-B-Math.sqrt(D))/(2*A);
    }
}
