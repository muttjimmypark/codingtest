package programmers.lev2.arraymultipleminimum;

import java.util.Arrays;

class Solution {
    int n;
    int[][] multipleMap;

    public int solution(int[] A, int[] B) {
        n = A.length;
        multipleMap = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                multipleMap[i][j] = A[i] * B[j];
            }
        }

        int answer = Integer.MAX_VALUE;

        //

        return answer;
    }
}