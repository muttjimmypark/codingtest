package kakao.secretmap2018;

// 2018 블라인드 1차 - 비밀지도
// 220913 16:00 - 16:44

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {

        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            StringBuilder tmp1 = new StringBuilder(Integer.toBinaryString(arr1[i] | arr2[i]));
            if (n > tmp1.length()) {
                int tmp = n - tmp1.length();
                for (int j = 0; j < tmp; j++) {
                    tmp1.insert(0, "0");
                }
            }
            StringBuilder tmp2 = new StringBuilder();

            for (int j = 0; j < n; j++) {
                if (tmp1.charAt(j) == '1') {
                    tmp2.append("#");
                } else {
                    tmp2.append(" ");
                }
            }
            answer[i] = tmp2.toString();
        }

        return answer;
    }
}