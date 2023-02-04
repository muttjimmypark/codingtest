package zum230203.q3;

class Solution {
    public int solution(int[] histogram) {
        int answer = -1;

        for (int i = 0; i < histogram.length - 2; i++) {
            for (int j = i + 2; j < histogram.length; j++) {
                int lowWall = Math.min(histogram[i], histogram[j]);
                answer = Math.max(answer, (j - i - 1) * lowWall);
            }
        }

        return answer;
    }
}