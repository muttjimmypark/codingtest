package codility.lv1binarygap;

class Solution {
    public int solution(int N) {
        String input = Integer.toBinaryString(N);

        boolean seek = false;
        int count = 0;
        int mx = 0;

        for (int i = 0; i < input.length(); i++) {

            if (input.charAt(i) == '1'
                    && !seek) {
                count = 0;
                seek = true;
                continue;
            }

            if (input.charAt(i) == '0'
                    && seek) {
                count++;
                continue;
            }

            if (input.charAt(i) == '1'
                    && seek) {
                mx = Math.max(mx, count);
                count = 0;
            }
        }

        return mx;
    }
}