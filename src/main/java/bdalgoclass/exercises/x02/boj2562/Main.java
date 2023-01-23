package bdalgoclass.exercises.x02.boj2562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] arr = new int[9];
        int max = 0;
        int idx = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());

            if (max < arr[i]) {
                max = arr[i];
                idx = i;
            }
        }

        System.out.println(max);
        System.out.println(idx + 1);
    }
}