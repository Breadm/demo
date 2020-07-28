package practice;

import java.util.Random;

import java.util.Scanner;


public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        char task = (char) (random.nextInt('Z'-'A'+1)+'A');
        char user;
        do {
            System.out.println("Введите букву A-Z");
            user = in.next().charAt(0);
            user = Character.toUpperCase(user);
            if (user > task)
                System.out.println("You’re too high");
            if (user < task)
                System.out.println("You’re too low");
        } while (user != task);
        System.out.println("Right");
    }
}
