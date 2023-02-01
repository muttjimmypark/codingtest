package bdalgoclass.exercises.x0B.boj1780;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] arr;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = new int[3];
        Arrays.fill(result, 0);

        solution(n, 0, 0);

        for (int i = 0; i < 3; i++) {
            System.out.println(result[i]);
        }
    }

    private static int solution(int input, int x, int y) {
        if (input == 1) {
            return arr[x][y];
        }

        int unitSize = input / 3;
        int[][] unitResults = new int[3][3];
        boolean nowAllSame = true;

        for (int i = 0; i < 3; i++) {

            Arrays.fill(unitResults[i], -2);

            for (int j = 0; j < 3; j++) {
                unitResults[i][j] = solution(unitSize, x + (i * unitSize), y + (j * unitSize));
                nowAllSame = nowAllSame && (unitResults[i][j] == unitResults[0][0]);
            }
        }

        if (nowAllSame) {
            if (input == n) {
                result[unitResults[0][0] + 1]++;
            }

            return unitResults[0][0];
        }

        //아니니까 각칸이 결과배열에 합산되게
        //리턴 -2
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int tmp = unitResults[i][j];
                if (tmp >= -1
                        && tmp <= 1) {
                    result[tmp + 1]++;
                }
            }
        }
        return -2;
    }
}