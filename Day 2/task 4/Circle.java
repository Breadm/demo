package practice;

import java.util.Scanner;

public class Circle extends Shape{
    private double x;
    private double y;
    private double r;

    public Circle(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    @Override
    public void print() {
        System.out.format("Circle: x: %.2f", x);
        System.out.format(" y: %.2f", y);
        System.out.format(" R: %.2f%n", r);
    }

    @Override
    public void move(double x, double y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public void scale(double scl) {
        r *= scl;
    }

    @Override
    public double square() {
        return 3.14 * r * r;
    }

    public  boolean pointInclude(Point point){
        return (point.getX() - x)*(point.getX() - x) +
                (point.getY() - y)*(point.getY() - y) <= r*r;
    }

    public  boolean circleInclude(Circle circle){
        return Math.sqrt((circle.x - this.x)*(circle.x - this.x) +
                (circle.y - this.y)*(circle.y - this.y)) + circle.r <= this.r ;
    }

    public double circum(){
        return 2 * 3.14 * r;
    }

    public void randomMove(){
        x = Math.random() * (99 - (-99) + 1) - 99;
        y = Math.random() * (99 - (-99) + 1) - 99;
    }

    public double circleDistance(Circle circle){
        return Math.sqrt((circle.x - this.x)*(circle.x - this.x)+
                (circle.y - this.y)*(circle.y - this.y));
    }

    public boolean circleContact(Circle circle){
        return this.circleDistance(circle) == Math.abs(this.r - circle.r) ||
                this.circleDistance(circle) == this.r + circle.r;
    }
}
