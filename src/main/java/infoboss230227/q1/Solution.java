package infoboss230227.q1;

class Solution {

    public int solution(int p, int m, int d) {

        for (int k = 0; k <= 100; k++) {
            if (cal(p, m, k) >= d) {
                return k;
            }
        }

        return -1;
    }

    private int cal(int p, int m, int k) {

        float e = 1;
        for (int i = 0; i < m; i++) {
            e *= (k + 100);
            e /= 100;
        }

        return (int) (p * e);
    }

}