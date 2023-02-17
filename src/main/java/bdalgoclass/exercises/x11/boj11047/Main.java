package bdalgoclass.exercises.x11.boj11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] moneyPrint;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        moneyPrint = new int[n];
        Arrays.fill(moneyPrint, 0);
        int start = 0;

        for (int i = 0; i < n; i++) {
            moneyPrint[i] = Integer.parseInt(br.readLine());

            if (moneyPrint[i] <= k) {
                start = i;
            }
        }

        System.out.println(solution(k, start, 0));

    }

    private static int solution(int money, int idx, int result) {
        if (money == 0) {
            return result;
        }

        int use = money / moneyPrint[idx];
        int remain = money % moneyPrint[idx];

        return solution(remain, idx - 1, result + use);
    }
}