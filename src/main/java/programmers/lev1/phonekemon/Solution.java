package programmers.lev1.phonekemon;

import java.util.Arrays;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        boolean[] flag = new boolean[200001];
        Arrays.fill(flag, false);

        for (int num : nums) {
            flag[num] = true;
        }

        for (boolean b : flag) {
            if (b) {
                answer++;
            }
        }

        return Math.min(answer, nums.length / 2);
    }
}