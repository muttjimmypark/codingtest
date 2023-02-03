package bdalgoclass.exercises.x10.boj1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] cases;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        cases = new int[n + 1];
        Arrays.fill(cases, -1);
        cases[1] = 0;

        for (int i = 2; i <= n; i++) {
            cases[i] = cases[i - 1];

            if (i % 2 == 0) {
                cases[i] = Math.min(cases[i], cases[i / 2]);
            }

            if (i % 3 == 0) {
                cases[i] = Math.min(cases[i], cases[i / 3]);
            }

            cases[i]++;
        }

        System.out.println(cases[n]);
    }
}