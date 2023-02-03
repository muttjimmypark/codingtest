package bdalgoclass.exercises.x10.boj2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] stairs;
    static int[][] mxScore;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        stairs = new int[count];
        for (int i = 0; i < count; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        mxScore = new int[2][count];
        Arrays.fill(mxScore[0], 0);
        Arrays.fill(mxScore[1], 0);

        for (int i = 0; i < count; i++) {
            if (i == 0) {
                mxScore[0][i] = stairs[i];
                mxScore[1][i] = stairs[i];
                continue;
            }

            if (i == 1) {
                mxScore[0][i] = stairs[i] + mxScore[1][i - 1];
                mxScore[1][i] = stairs[i];
                continue;
            }

            mxScore[0][i] = stairs[i] + mxScore[1][i - 1];
            mxScore[1][i] = stairs[i] + Math.max(mxScore[0][i - 2], mxScore[1][i - 2]);
        }

        System.out.println(Math.max(mxScore[0][count - 1], mxScore[1][count - 1]));
    }

}