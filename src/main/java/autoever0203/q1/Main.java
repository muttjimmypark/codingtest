package autoever0203.q1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static long time = System.currentTimeMillis();
    static int m;
    static int[] createdCase;
    static int minimum;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        m = Integer.parseInt(br.readLine());

        minimum = 15001;
        createdCase = new int[3];
        result = new int[3];
        Arrays.fill(createdCase, 0);
        Arrays.fill(result, 0);

        backTracking(0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);

        //
        System.out.println(System.currentTimeMillis() - time);
    }

    private static void backTracking(int idx) {

        if (idx == 3) {
            int tmp = makeArea(createdCase);

            if (validLength()
                    && tmp < minimum) {
                minimum = tmp;
                result = createdCase.clone();
            }
            return;
        }

        for (int i = 1; i <= 50; i++) {
            createdCase[idx] = i;
            backTracking(idx + 1);
        }
    }

    private static boolean validLength() {
        return m <= (createdCase[0] * createdCase[1] * createdCase[2]);
    }

    private static int makeArea(int[] abc) {
        return ((abc[0] * abc[1]) + (abc[0] * abc[2]) + (abc[1] * abc[2])) * 2;
    }
}
