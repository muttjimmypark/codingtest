package bdalgoclass.exercises.x0B.boj1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(solution(n, r, c));
    }

    private static int solution(int n, int r, int c) {
        if (n == 0) {
            return 0;
        }

        int mid = (int) Math.pow(2, n - 1);
        int mass = mid * mid;

        if (r < mid) {
            if (c < mid) {
                return solution(n - 1, r, c);
            }
            return mass + solution(n - 1, r, c - mid);
        }
        if (c < mid) {
            return (mass * 2) + solution(n - 1, r - mid, c);
        }
        return (mass * 3) + solution(n - 1, r - mid, c - mid);
    }
}