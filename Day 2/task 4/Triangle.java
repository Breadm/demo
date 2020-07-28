package practice;

public class Triangle extends Shape{
    private Point p1, p2, p3;
    private double ed1, ed2, ed3;
    private double halfPerimeter;

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public Point getP3() {
        return p3;
    }

    public Triangle(Point p1, Point p2, Point p3) {
        if (p1.collinearPoints(p2,p3)) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        ed1 = p1.distance(p2);
        ed2 = p2.distance(p3);
        ed3 = p1.distance(p3);
        halfPerimeter = perimeter()/2;
        } else
            System.out.println("Invalid points");
    }

    public Triangle() {
        do {
            System.out.print("Set valid points \n1 ");
            p1 = new Point();
            System.out.print("2 ");
            p2 = new Point();
            System.out.print("3  ");
            p3 = new Point();
        }  while (p1.collinearPoints(p2,p3));
        ed1 = p1.distance(p2);
        ed2 = p2.distance(p3);
        ed3 = p1.distance(p3);
        halfPerimeter = perimeter()/2;
    }

    @Override
    public void print() {
        System.out.println("Triangle:");
        p1.print();
        p2.print();
        p3.print();
    }

    @Override
    public void move(double x, double y) {
        p1.move(x,y);
        p2.move(x,y);
        p3.move(x,y);
    }

    @Override
    public void scale(double scl) {
        p1.scale(scl);
        p2.scale(scl);
        p3.scale(scl);
    }

    @Override
    public double square() {
        return Math.sqrt(halfPerimeter *(halfPerimeter -ed1)*
                (halfPerimeter -ed2)*(halfPerimeter -ed3));
    }

    public double perimeter(){
        return ed1 + ed2 + ed3;
    }

    public void rotate(double deg){
        Point center = new Point((p1.getX()+p2.getX()+p3.getX())/3,
                (p1.getY()+p2.getY()+p3.getY())/3 );
        p1.rotate(deg,center);
        p2.rotate(deg,center);
        p3.rotate(deg,center);
    }


}
