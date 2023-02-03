package codility.demo;

import java.util.Arrays;

class Solution {
    /**
     * MissingInteger
     */

    public int solution(int[] A) {
        boolean[] arr = new boolean[100001];
        Arrays.fill(arr, false);

        for (int i : A) {
            if (i > 0) {
                arr[i] = true;
            }
        }

        for (int i = 1; i < arr.length; i++) {
            if (!arr[i]) {
                return i;
            }
        }
        return 100000;
    }
}