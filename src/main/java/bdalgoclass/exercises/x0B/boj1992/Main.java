package bdalgoclass.exercises.x0B.boj1992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static boolean[][] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        input = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < n; j++) {
                input[i][j] = tmp.charAt(j) == '1';
            }
        }

        System.out.println(sol(0, 0, n));
    }
    private static String sol(int x, int y, int len) {

        boolean start = input[x][y];

        if (len == 1) {
            return Integer.toString(start ? 1 : 0);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {

                if (start != input[i][j]) {
                    int sub = len / 2;
                    sb.append("(")
                            .append(sol(x, y, sub))
                            .append(sol(x, y + sub, sub))
                            .append(sol(x + sub, y, sub))
                            .append(sol(x + sub, y + sub, sub))
                            .append(")");
                    return sb.toString();
                }
            }
        }

        return Integer.toString(start ? 1 : 0);
    }
}