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

        if (len == 1) {
            return Integer.toString(input[x][y] ? 1 : 0);
        }

        int sub = len / 2;
        String a = sol(x, y, sub);
        String b = sol(x + sub, y, sub);
        String c = sol(x, y + sub, sub);
        String d = sol(x + sub, y + sub, sub);

        if (a.equals(b)
                && b.equals(c)
                && c.equals(d)) {
            return a;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("(");

        sb.append(a).append(b).append(c).append(d);

        sb.append(")");
        return sb.toString();

    }
}