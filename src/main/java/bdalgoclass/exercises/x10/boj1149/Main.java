package bdalgoclass.exercises.x10.boj1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] inputs;
    static int[][] costs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        inputs = new int[3][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                inputs[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        costs = new int[3][n];
        Arrays.fill(costs[0], 0);
        Arrays.fill(costs[1], 0);
        Arrays.fill(costs[2], 0);

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                costs[0][i] = inputs[0][i];
                costs[1][i] = inputs[1][i];
                costs[2][i] = inputs[2][i];
                continue;
            }

            costs[0][i] = inputs[0][i] + Math.min(costs[1][i - 1], costs[2][i - 1]);
            costs[1][i] = inputs[1][i] + Math.min(costs[0][i - 1], costs[2][i - 1]);
            costs[2][i] = inputs[2][i] + Math.min(costs[1][i - 1], costs[0][i - 1]);
        }

        int result = 1001 * n;
        for (int i = 0; i < 3; i++) {
            result = Math.min(result, costs[i][n - 1]);
        }
        System.out.println(result);
    }
}