package bdalgoclass.exercises.x02.boj2587;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int[] arr = new int[5];
        int sum = 0;

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(sc.nextLine());
            sum += arr[i];
        }

        int[] result = Arrays.stream(arr).sorted().toArray();

        System.out.println(sum / 5);
        System.out.println(result[2]);
    }
}