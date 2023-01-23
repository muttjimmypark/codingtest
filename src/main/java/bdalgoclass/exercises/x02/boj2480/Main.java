package bdalgoclass.exercises.x02.boj2480;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int[] eyes = new int[6];
        Arrays.fill(eyes, 0);
        int max = 0;

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            int tmp = sc.nextInt();
            eyes[tmp - 1]++;
            max = Math.max(tmp, max);
        }

        int money = 0;
        for (int i = 6; i >= 1; i--) {
            if (eyes[i - 1] == 3) {
                money = 10000 + (i * 1000);
                break;
            }
            if (eyes[i - 1] == 2) {
                money = 1000 + (i * 100);
                break;
            }
        }

        if (money == 0) {
            money = max * 100;
        }
        System.out.println(money);

    }
}