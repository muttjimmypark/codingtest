package programmers.lev2.minmax;

class Solution {
    public String solution(String s) {
        String[] input = s.split(" ");

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (String tmp : input) {
            int now = Integer.parseInt(tmp);

            if (now < min) {
                min = now;
            }

            if (now > max) {
                max = now;
            }
        }

        return min + " " + max;
    }
}