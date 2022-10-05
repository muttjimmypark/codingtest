package programmers.lev0.ongal;

class Solution {
    String[] ban = {"ayaaya", "yeye", "woowoo", "mama"};
    String[] right = {"aya", "ye", "woo", "ma"};

    public int solution(String[] babbling) {
        int answer = 0;

        for (String speak : babbling) {
            String tmp = speak;

            for (String s : ban) {
                tmp = tmp.replace(s, "x");
            }

            for (String s : right) {
                tmp = tmp.replace(s, "");
            }

            if (tmp.length() == 0) {
                answer++;
            }
        }

        return answer;
    }
}
