package programmers.lev2.continuousnumber;

class Solution {
    public int solution(int n) {

        if (n < 3) {
            return 1;
        }

        int start = n / 2;
        if (n % 2 == 1) {
            start++;
        }

        int answer = 1;
        for (int i = start; i > 0; i--) {
            int trigger = solve(i, n);

            if (trigger == 1) {
                answer++;
                continue;
            }
            if (trigger == 2) {
                break;
            }
        }

        return answer;
    }

    private int solve(int start, int n) {
        int tmp = start;
        for (int i = start - 1; i > 0; i--) {
            tmp += i;
            if (tmp > n) {
                return 0;
            }
            if (tmp == n) {
                return 1;
            }
            if (i == 1) {
                return 2;
            }
        }
        return 0;
    }
}
