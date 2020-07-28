package practice;

public class Main {
    public static void main(String[] args){
        double a = 2;
        double b = 7;
        double c = -4;
        double d = b*b - 4*a*c;
        double x1,x2;
        if (d > 0) {
            x1 = (-b + Math.sqrt(d))/(2*a);
            x2 = (-b - Math.sqrt(d))/(2*a);
            System.out.println("x1 = " + x1 + " x2 =" + x2 );
        } else if (d < 0) {
            System.out.println("Корней нет");
        } else {
            x1 = -b/2 + Math.sqrt(d);
            System.out.println("x = " + x1);
        }
    }
}