package bdalgoclass.exercises.x02.boj2576;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int sum = 0;
        int min = 101;

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 7; i++) {
            int tmp = sc.nextInt();

            if (tmp % 2 == 1) {
                sum += tmp;
                min = Math.min(min, tmp);
            }
        }
//        sc.nextLine();

        if (sum == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(sum);
        System.out.println(min);
    }
}