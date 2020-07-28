package practice;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int Num = in.nextInt();
        int n1 = 0;
        int n2 = 1;
        System.out.print("0 1 ");
        for (int n3 = 1; n3 < Num; n3 = n1 + n2){
            n1 = n2; n2 = n3;
            System.out.print( n3 + " ");
        }

    }
}
