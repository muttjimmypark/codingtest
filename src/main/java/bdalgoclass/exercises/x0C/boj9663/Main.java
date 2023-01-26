package bdalgoclass.exercises.x0C.boj9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n;
    static int[] queenIdx;
    static boolean[] colFlag;
    static boolean[] diagFlag;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        queenIdx = new int[n];
        colFlag = new boolean[n];
        diagFlag = new boolean[n + n + 1];
        Arrays.fill(queenIdx, -1);
        Arrays.fill(colFlag, false);
        Arrays.fill(diagFlag, false);
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
                    && differDiag(row, i)) {
                colFlag[i] = true;
                diagFlag[i + row + 2] = true;
                diagFlag[i - row] = true;
                queenIdx[row] = i;
                solution(row + 1);
                colFlag[i] = false;
                diagFlag[i + row + 2] = false;
                diagFlag[i - row] = false;
            }
        }
    }

    //colflag를 2차원으로 만들어서 diagol 판독방법 다시
}
/**
 * 말이 놓인 인덱스들을 피해야 (직선)
 * 또는
 * 당장 윗말의 대각선 (대각선, 2줄 넘어가면 다른말 인덱스등과 겹쳐)
 */