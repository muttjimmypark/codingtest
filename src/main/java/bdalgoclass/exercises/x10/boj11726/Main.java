package bdalgoclass.exercises.x10.boj11726;

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
        Arrays.fill(cases, 0);

        for (int i = 1; i <= n; i++) {
            if (i <= 2) {
                cases[i] = i;
                continue;
            }

            cases[i] = (cases[i - 1] + cases[i - 2]) % 10007;
        }

        System.out.println(cases[n]);
    }
}