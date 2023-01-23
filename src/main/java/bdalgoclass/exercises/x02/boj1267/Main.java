package bdalgoclass.exercises.x02.boj1267;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        int ys = 0;
        int ms = 0;
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();

            ys += ysVerify(tmp);
            ms += msVerify(tmp);
        }

        if (ms >= ys) {
            System.out.print("Y ");
        }
        if (ys >= ms) {
            System.out.print("M ");
        }
        System.out.println(Math.min(ys, ms));
    }

    private static int ysVerify(int time) {
        return ((time / 30) + 1) * 10;
    }

    private static int msVerify(int time) {
        return ((time / 60) + 1) * 15;
    }
}