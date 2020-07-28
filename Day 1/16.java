package practice;

public class Main {
    public static void main(String[] args){
        int sum = 0;
        for (int i = 1; i < 50000; i++){
            int j = i;
            while (j > 0) {
                if (j%10 == 2) {
                    sum++;
                    break;
                }
                j/=10;
            }
        }
        System.out.println(sum);
    }
}