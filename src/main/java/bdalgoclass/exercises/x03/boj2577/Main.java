package bdalgoclass.exercises.x03.boj2577;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int abc = 1;
        for (int i = 0; i < 3; i++) {
            abc *= Integer.parseInt(br.readLine());
        }

        int howlong = Integer.toString(abc).length();
        int[] arr = new int[10];
        Arrays.fill(arr, 0);
        for (int i = 0; i < howlong; i++) {
            int right = abc % 10;
            arr[right]++;
            abc /= 10;
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(arr[i]);
        }
    }
}