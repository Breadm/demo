package practice;

import java.util.Random;

public class Main {
    public static void main(String[] args){
        int a = 5;
        int b = 10;
        Random random = new Random();
        System.out.println(random.nextInt(b - a + 1) + a);
    }
}
