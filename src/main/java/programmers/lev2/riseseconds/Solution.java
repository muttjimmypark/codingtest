package programmers.lev2.riseseconds;

class Solution {

    int[] answer;

    public int[] solution(int[] prices) {

        answer = prices.clone();
        for (int i = 0; i < answer.length; i++) {
            answer[i] = solve(i);
        }
        return answer;
    }

    private int solve(int i) {
        int point = answer[i];
        int result = 0;

        for (int j = i + 1; j < answer.length; j++) {
            result++;
            if (answer[j] < point) {
                break;
            }
        }

        return result;
    }
}