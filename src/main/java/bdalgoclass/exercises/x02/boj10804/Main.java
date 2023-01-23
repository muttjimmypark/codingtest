package bdalgoclass.exercises.x02.boj10804;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int[] arr = new int[21];
        for (int i = 0; i < 21; i++) {
            arr[i] = i;
        }

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            sc.nextLine();

            while (start < end) {
                int tmp = arr[start];
                arr[start] = arr[end];
                arr[end] = tmp;

                start++;
                end--;
            }
        }

        for (int i = 1; i <= 20; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}