package bdalgoclass.exercises.x0C.boj15663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int m;
    static int[] have;
    static int[] outTmp;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        have = new int[10001];
        Arrays.fill(have, 0);

        st.nextToken(); //n
        m = Integer.parseInt(st.nextToken());
        outTmp = new int[m];
        Arrays.fill(outTmp, 0);

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            have[Integer.parseInt(st.nextToken())]++;
        }

        sb = new StringBuilder();
        solution(0);

        System.out.println(sb);
    }

    private static void solution(int idx) {
        if (idx == m) {
            for (int i = 0; i < m; i++) {
                sb.append(outTmp[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        for (int i = 1; i <= 10000; i++) {
            if (have[i] > 0) {
                outTmp[idx] = i;
                have[i]--;
                solution(idx + 1);
                have[i]++;
            }
        }
    }
}