package practice;

import java.util.Random;

import java.util.Scanner;


public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Введите размер массива");
        int N = in.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = random.nextInt(100);
        }
        int n = 0;
        while (n != 3) {
            System.out.println("1. Вывести массив\n" +
                    "2. Увеличить элемент массива на 10%\n" +
                    "3. Выход");
            n = in.nextInt();
            switch (n) {
                case 1:
                    for (int i = 0; i < N; i++) {
                    System.out.print(arr[i] + " ");
                    }
                    System.out.println();
                    n = 0;
                    break;
                case 2:
                    System.out.println("Введите номер элемента");
                    n = in.nextInt();
                    arr[n] *= 1.1;
                    n = 0;
                    break;
            }
        }

    }
}
