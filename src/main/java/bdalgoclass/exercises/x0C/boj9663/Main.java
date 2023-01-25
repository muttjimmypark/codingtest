package bdalgoclass.exercises.x0C.boj9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n;
    static int[] queenIdx;
    static boolean[] history;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        queenIdx = new int[n];
        history = new boolean[n];
        Arrays.fill(queenIdx, -1);
        Arrays.fill(history, false);
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
            if (!history[i]
                    && !diagonal(i, row - 1)) {
                history[i] = true;
                queenIdx[row] = i;
                solution(row + 1);
                history[i] = false;
            }
        }
    }

    private static boolean diagonal(int num, int upperRow) {
        if (upperRow < 0) {
            return false;
        }
        return num < queenIdx[upperRow] - 1
                || num > queenIdx[upperRow] + 1;
    }
}
/**
 * 말이 놓인 인덱스들을 피해야 (직선)
 * 또는
 * 당장 윗말의 대각선 (대각선, 2줄 넘어가면 다른말 인덱스등과 겹쳐)
 */