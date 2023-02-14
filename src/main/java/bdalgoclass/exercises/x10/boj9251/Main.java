package bdalgoclass.exercises.x10.boj9251;

/**
 * 2차원 메모 기반 dp
 * 1. 메모를 어떻게 구성할지
 * 2. 실제 주어지는 규칙성이 메모 안에서 어떻게 발현되는지
 * 3. 그 원리를 통해 역추적을 구현
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static String a;
    static String b;
    static int[][] lcs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        a = br.readLine();
        b = br.readLine();

        lcs = new int[a.length()][b.length()];
        for (int i = 0; i < a.length(); i++) {
            Arrays.fill(lcs[i], -1);
        }

        solution(a.length() - 1, b.length() - 1);

        System.out.println(lcs[a.length() - 1][b.length() - 1]);
    }

    private static int solution(int x, int y) {

        if (x < 0 || y < 0) {
            return 0;
        }

        if (lcs[x][y] != -1) {
            return lcs[x][y];
        }

        char ax = a.charAt(x);
        char by = b.charAt(y);
        int tmp;

        if (ax == by) {
            tmp = solution(x - 1, y - 1);
            lcs[x][y] = ++tmp;
            return tmp;
        } else  {
            tmp = Math.max(solution(x - 1, y), solution(x, y - 1));
            lcs[x][y] = tmp;
            return tmp;
        }

    }

}