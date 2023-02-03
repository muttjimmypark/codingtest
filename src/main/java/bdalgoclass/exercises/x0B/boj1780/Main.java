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

    private static void solution(int input, int x, int y) {

        if (validAllSame(input, x, y)) {
            result[arr[x][y] + 1]++;
            return;
        }

        int unitSize = input / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                solution(unitSize, x + (i * unitSize), y + (j * unitSize));
            }
        }
    }

    private static boolean validAllSame(int input, int x, int y) {
        for (int i = x; i < x + input; i++) {
            for (int j = y; j < y + input; j++) {
                if (arr[x][y] != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}