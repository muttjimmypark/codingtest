package bdalgoclass.exercises.x0E.boj10989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] freq;

    public static void main(String[] args) throws IOException {
        freq = new int[10000001];
        Arrays.fill(freq, 0);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            freq[Integer.parseInt(br.readLine())]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10000000; i++) {
            for (int j = 0; j < freq[i]; j++) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);

    }
}