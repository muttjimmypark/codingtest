package programmers.lev3.multiset;

import java.util.Arrays;

class Solution {

    int[] result;
    int idx;

    public int[] solution(int n, int s) {
        if (s < n) {
            return new int[]{-1};
        }

        result = new int[n];
        if (s == n) {
            Arrays.fill(result, 1);
            return result;
        }

        Arrays.fill(result, 0);
        idx = 0;

        solu(n, s);
        Arrays.sort(result);

        return result;
    }

    private void solu(int n, int s) {
        if (n == 1) {
            result[idx++] = s;
            return;
        }

        int av = s / n;
        result[idx++] = av;
        solu(n - 1, s - av);
    }
}