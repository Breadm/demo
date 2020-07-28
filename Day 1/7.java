package practice;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        for (int i = 2; i < num; i++) {
            if (num % i == 0)
                System.out.print(i + " ");
        }
        System.out.println();
        }

    }
}
