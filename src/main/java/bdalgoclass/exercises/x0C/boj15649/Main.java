package bdalgoclass.exercises.x0C.boj15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int n;
    static boolean[] flag;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        flag = new boolean[n + 1];
        Arrays.fill(flag, false);

        int m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        Arrays.fill(arr, 0);

        sb = new StringBuilder();
        solution(0);
        System.out.println(sb);
    }

    private static void solution(int idx) {
        if (idx == arr.length) {
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!flag[i]) {
                flag[i] = true;
                arr[idx] = i;
                solution(idx + 1);
                flag[i] = false;
            }
        }
    }
}