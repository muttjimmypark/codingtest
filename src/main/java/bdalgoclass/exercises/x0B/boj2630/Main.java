package bdalgoclass.exercises.x0B.boj2630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[][] arr;
    static int[] whiteBlue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        whiteBlue = new int[2];
        Arrays.fill(whiteBlue, 0);

        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        solve(n, 0, 0);

        for (int i : whiteBlue) {
            System.out.println(i);
        }
    }

    private static void solve(int n, int x, int y) {
        if (n == 1) {
            whiteBlue[arr[x][y]]++;
            return;
        }

        int unit = oneColor(n, x, y);
        if (unit < 2) {
            whiteBlue[unit]++;
            return;
        }

        unit = n / 2;
        solve(unit, x, y);
        solve(unit, x + unit, y);
        solve(unit, x, y + unit);
        solve(unit, x + unit, y + unit);
    }

    private static int oneColor(int n, int x, int y) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[x][y] != arr[x + i][y + j]) {
                    return 2;
                }
            }
        }

        return arr[x][y];
    }

}