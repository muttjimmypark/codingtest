package bdalgoclass.boj10808;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int[] arr = new int[26];
        Arrays.fill(arr, 0);

        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }

    }
}