package bdalgoclass.exercises.x0F.boj15688;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] freq;

    public static void main(String[] args) throws IOException {
        freq = new int[2000002];
        Arrays.fill(freq, 0);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            freq[Integer.parseInt(br.readLine()) + 1000000]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2000002; i++) {
            for (int j = 0; j < freq[i]; j++) {
                sb.append(i - 1000000).append("\n");
            }
        }

        System.out.println(sb);

    }
}