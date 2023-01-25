package bdalgoclass.exercises.x0B.boj11729;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(solution(n, 1, 3));
        System.out.println(sb);
    }

    private static int solution(int floor, int start, int goal) {
        if (floor == 1) {
            sb.append(start + " " + goal + "\n");
            return 1;
        }

        int mid = 6 - start - goal;
        int result = 1;

        result += solution(floor - 1, start, mid);
        sb.append(start + " " + goal + "\n");
        result += solution(floor - 1, mid, goal);

        return result;
    }
}