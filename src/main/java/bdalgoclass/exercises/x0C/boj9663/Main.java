package bdalgoclass.exercises.x0C.boj9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n;
    static int[] queenIdx;
    static boolean[] colFlag;
    static boolean[] riseFlag;
    static boolean[] downFlag;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        queenIdx = new int[n];
        colFlag = new boolean[n];
        riseFlag = new boolean[n * 2 + 1];
        downFlag = new boolean[n * 2 + 1];
        Arrays.fill(queenIdx, -1);
        Arrays.fill(colFlag, false);
        Arrays.fill(riseFlag, false);
        Arrays.fill(downFlag, false);
        count = 0;

        solution(0);
        System.out.println(count);
    }

    private static void solution(int row) {
        if (row == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!colFlag[i]
                    && !riseFlag[i + row + 2]
                    && !downFlag[i - row + n]) {
                colFlag[i] = true;
                riseFlag[i + row + 2] = true;
                downFlag[i - row + n] = true;
                queenIdx[row] = i;
                solution(row + 1);
                colFlag[i] = false;
                riseFlag[i + row + 2] = false;
                downFlag[i - row + n] = false;
            }
        }
    }
}