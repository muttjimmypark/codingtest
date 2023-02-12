package springintern230211.q3;

import java.util.Arrays;

class Solution {
    public int[] solution(int[][] queries) {
        int[] answer = new int[queries.length];
        Arrays.fill(answer, 2);

        for (int i = 0; i < queries.length; i++) {
            int head = 0;
            int tail = queries[i].length;
            int result = 0;

            while (tail > head) {
                if ((tail - head) == 1) {
                    if (queries[i][head] % 2 == 1) {
                        answer[i] = 1;
                        break;
                    }
                }

                int ap = queries[i][head++];
                int dwi = queries[i][--tail];

                result += Math.abs(dwi - ap);
            }

            if (answer[i] == 2) {
                answer[i] = result % 2;
            }
        }

        return answer;
    }
}

//123 789