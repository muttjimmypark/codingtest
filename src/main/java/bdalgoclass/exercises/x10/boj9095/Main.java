package bdalgoclass.exercises.x10.boj9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int mx = 0;
        int[] inputs = new int[n];
        for (int i = 0; i < n; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
            mx = Math.max(mx, inputs[i]);
        }

        arr = new int[mx + 1];
        Arrays.fill(arr, 0);
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;

        for (int i = 2; i <= mx; i++) {
            arr[i] += arr[i - 1];

            if (i - 2 > 0) {
                arr[i] += arr[i - 2];
            }

            if (i - 3 > 0) {
                arr[i] += arr[i - 3];
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(arr[inputs[i]]);
        }
    }
}