package practice;

import java.util.Scanner;

public class Point extends Shape {
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void print() {
        System.out.format("Point: x: %.2f", x);
        System.out.format(" y: %.2f%n", y);
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public void move(double x, double y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public void scale(double scl) {
        x *= scl;
        y *= scl;
    }

    @Override
    public double square() {
        return 0;
    }

    public int quadrant(){
        if (x > 0 && y > 0)
            return 1;
        else if (x < 0 && y > 0)
            return 2;
        else if (x < 0 && y < 0)
            return 3;
        else if (x > 0 && y < 0)
            return 4;
        else
            return 0;
    }

    public boolean symmetricPoints(Point point){
        return (this.x == -point.x) &&  (this.y == -point.y);
    }

    public boolean collinearPoints(Point point1, Point point2){
        return ((this.x-point2.x)*(point1.y-point2.y)) ==
                ((point1.x-point2.x)*(this.y-point2.y));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (Double.compare(point.x, x) != 0) return false;
        return Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
    public double distance(Point point){
        return Math.sqrt((this.x - point.x)*(this.x - point.x)+
                (this.y - point.y)*(this.y - point.y));
    }

    public void rotate(double deg, Point p){
        double angle = deg * Math.PI/180;
        this.x = (this.x - p.x) * Math.cos(angle)
                - (this.y - p.y) * Math.sin(angle) + p.x;
        this.y = (this.x - p.x) * Math.sin(angle)
                + (this.y - p.y) * Math.cos(angle) + p.y;
    }
}

