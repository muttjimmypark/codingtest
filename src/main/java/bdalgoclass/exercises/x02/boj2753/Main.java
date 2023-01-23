package bdalgoclass.exercises.x02.boj2753;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();

        if (year % 400 == 0) {
            System.out.println(1);
            return;
        }

        if (year % 4 == 0
                && year % 100 != 0) {
            System.out.println(1);
            return;
        }

        System.out.println(0);
    }
}