package programmers.lev0.parallel;

import java.util.ArrayList;
import java.util.List;

class Solution {
    int[][] gdots;

    public int solution(int[][] dots) {
        int answer = 0;
        gdots = dots.clone();

        for (int i = 1; i <= 3; i++) {
            if (solve(i)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean solve(int withZero) {
        List<Integer> remain = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            if (i != withZero) {
                remain.add(i);
            }
        }

        float gak1 = makeGak(0, withZero);
        float gak2 = makeGak(remain.get(0), remain.get(1));
        float gak3 = makeGak(remain.get(1), remain.get(0));

        return Float.compare(gak1, gak2) == 0
                | Float.compare(gak1, gak3) == 0;
    }

    private float makeGak(int d1, int d2) {
        float tmp1 = gdots[d2][1] - gdots[d1][1];
        float tmp2 = gdots[d2][0] - gdots[d1][0];
        return tmp1 / tmp2;
    }
}