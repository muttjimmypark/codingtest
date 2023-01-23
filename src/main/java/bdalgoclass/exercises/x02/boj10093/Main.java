package bdalgoclass.exercises.x02.boj10093;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();

        if (a == b) {
            System.out.println(0);
            return;
        }
        if (a > b) {
            long tmp = a;
            a = b;
            b = tmp;
        }

        System.out.println(b - a - 1);

        for (long i = a + 1; i < b; i++) {
            System.out.print(i + " ");
        }
    }
}