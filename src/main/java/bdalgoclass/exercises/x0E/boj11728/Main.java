package bdalgoclass.exercises.x0E.boj11728;

/**
 * merge sort
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = Arrays.stream(br.readLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        int[] b = Arrays.stream(br.readLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        StringBuilder sb = new StringBuilder();

        int aIdx = 0;
        int bIdx = 0;

        for (int i = 0; i < n + m; i++) {
            if (aIdx == n) {
                sb.append(b[bIdx]).append(" ");
                bIdx++;
                continue;
            }

            if (bIdx == m) {
                sb.append(a[aIdx]).append(" ");
                aIdx++;
                continue;
            }

            if (a[aIdx] >= b[bIdx]) {
                sb.append(b[bIdx]).append(" ");
                bIdx++;
                continue;
            }

            if (a[aIdx] < b[bIdx]) {
                sb.append(a[aIdx]).append(" ");
                aIdx++;
            }
        }

        System.out.println(sb);
    }
}