package practice;

public class Main {
    public static void main(String[] args){
        boolean flag = true;
        for (int i = 2; i <= 100; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
                if(flag && j==i-1)
                    System.out.print(i + " ");
                flag = true;
            }
        }
        System.out.println();
        }

    }
}
