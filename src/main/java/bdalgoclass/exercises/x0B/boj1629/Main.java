package bdalgoclass.exercises.x0B.boj1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        System.out.println(solution(a, b, c));
    }

    private static long solution(long a, long b, long c) {

        if (b == 1) {
            return a % c;
        }

        long result = solution(a, b / 2, c);
        result = result * result % c;

        if (b % 2 == 1) {
            result = result * a % c;
        }

        return result;
    }

}