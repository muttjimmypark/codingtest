package bdalgoclass.exercises.x02.boj2490;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {

            char yut = 'A' - 1;

            for (int j = 0; j < 4; j++) {
                if (sc.nextInt() == 0) {
                    yut++;
                }
            }
            sc.nextLine();

            if (yut == 'A' - 1) {
                yut = 'E';
            }

            System.out.println(yut);

        }
    }
}