package programmers.lev2.square21;

import java.util.Arrays;

class Solution {
    public static final int CUTTER = 1000000007;
    int[] memo;

    public int solution(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        memo[2] = 3;

        return solve(n);
    }

    private int solve(int n) {
        if (memo[n] != -1) {
            return memo[n];
        }

        int ans = 2;
        for (int i = 2; i < n; i += 2) {
            ans += solve(i) * solve(n - i);
        }

        memo[n] = ans % CUTTER;
        return memo[n];
    }

}