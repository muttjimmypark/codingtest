package bdalgoclass.exercises.x10.boj1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[][] fiboMemo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        fiboMemo = new int[41][2];
        for (int i = 0; i < 41; i++) {
            fiboMemo[i][0] = -1;
            fiboMemo[i][1] = -1;
        }

        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int[] now = fibonacci(Integer.parseInt(br.readLine()));
            sb.append(now[0]).append(" ").append(now[1]).append("\n");
        }

        System.out.println(sb);
    }

    private static int[] fibonacci(int n) {
        if (!Arrays.equals(fiboMemo[n], new int[]{-1, -1})) {
            return fiboMemo[n];
        }

        int[] now = {0, 0};

        if (n == 0) {
            now[0]++;
            fiboMemo[n] = now;
            return now;
        }

        if (n == 1) {
            now[1]++;
            fiboMemo[n] = now;
            return now;
        }

        int[] a = fibonacci(n - 1);
        int[] b = fibonacci(n - 2);
        now[0] = a[0] + b[0];
        now[1] = a[1] + b[1];
        fiboMemo[n] = now;
        return now;
    }
}