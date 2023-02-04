package zum230203.q2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public static final int MAX_TIME = 100000000;
    public static final int MAX_PAGE = 100000;

    public int[] solution(int[][] data) {

        int[] answer = new int[data.length];
        Arrays.fill(answer, 0);

        boolean[] used = new boolean[data.length];
        Arrays.fill(used, false);

        int[] call = new int[MAX_TIME + 1];
        Arrays.fill(call, 0);
        for (int i = 0; i < data.length; i++) {
            call[data[i][1]] = data[i][0];
        }

        answer[0] = data[0][0];
        used[0] = true;

        int[] print = new int[MAX_TIME + 1];
        Arrays.fill(print, 0);

        int printIdx = 0;
        for (int i = 1; i <= MAX_TIME; i++) {

        }

        return answer;
    }

}