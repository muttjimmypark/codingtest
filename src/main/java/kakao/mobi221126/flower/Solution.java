package kakao.mobi221126.flower;

import java.util.Arrays;

class Solution {
    int[] bloomDays;

    public int solution(int[][] flowers) {
        bloomDays = new int[365];
        Arrays.fill(bloomDays, 0);

        for (int[] flower : flowers) {
            mark(flower);
        }

        int answer = 0;
        for (int i = 0; i < bloomDays.length; i++) {
            if (bloomDays[i] > 0) {
                answer++;
            }
        }
        return answer;
    }

    private void mark(int[] flower) {
        for (int i = flower[0] - 1; i < flower[1] - 1; i++) {
            bloomDays[i]++;
        }
    }
}