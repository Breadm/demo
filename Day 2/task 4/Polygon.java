package practice;

import java.util.Scanner;

public class Polygon extends Shape {
    Point[] pts;
    int n;

    public Polygon(Point[] pts, int n) {
        this.pts = pts;
        this.n = n;
    }

    @Override
    public void print() {
        for (int i = 0; i < n; i++){
            System.out.print(i + " ");
            pts[i].print();
        }
    }

    @Override
    public void move(double x, double y) {
        for (int i = 0; i < n; i++){
            pts[i].move(x,y);
        }
    }

    @Override
    public void scale(double scl) {
        for (int i = 0; i < n; i++){
            pts[i].scale(scl);
        }
    }

    @Override
    public double square() {
        return -1;
    }

    public double perimeter(){
        double result = 0;
        for (int i = 0; i < n-1; i++){
            result += pts[i].distance(pts[i+1]);
        }
        result += pts[0].distance(pts[n]);
        return result;
    }
}
