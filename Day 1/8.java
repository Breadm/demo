package practice;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        boolean fl = true;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                fl = false;
                break;
            }
        }
        System.out.println(fl);
        }

    }
}
