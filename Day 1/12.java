package practice;

import java.util.Scanner;


public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int n = in.nextInt();
        if (n < s.length())
            s = String.join("", s.substring(0, n), s.substring(n+1));
        System.out.println(s);
    }
}
