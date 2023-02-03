package bdalgoclass.exercises.x10.boj12852;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] costs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        costs = new int[n + 1][2];

        costs[1][0] = 0;
        costs[1][1] = 0;

        for (int i = 2; i <= n; i++) {
            int tmpCost = costs[i - 1][0] + 1;
            int tmpIdx = i - 1;

            if (i % 2 == 0) {
                int mn = Math.min(tmpCost, costs[i / 2][0] + 1);
                if (tmpCost != mn) {
                    tmpCost = mn;
                    tmpIdx = i / 2;
                }
            }

            if (i % 3 == 0) {
                int mn = Math.min(tmpCost, costs[i / 3][0] + 1);
                if (tmpCost != mn) {
                    tmpCost = mn;
                    tmpIdx = i / 3;
                }
            }

            costs[i][0] = tmpCost;
            costs[i][1] = tmpIdx;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(costs[n][0]).append("\n");

        int idx = n;
        while (true) {
            sb.append(idx).append(" ");
            if (idx == 1) {
                break;
            }
            idx = costs[idx][1];
        }

        System.out.println(sb);
    }
}