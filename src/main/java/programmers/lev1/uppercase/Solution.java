package programmers.lev1.uppercase;

// 다중 공백도 별도의 idx를 쓰니까 해결되는데 왜 막히는지
class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();

        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                answer.append(" ");
                idx = 0;
                continue;
            }

            if (idx % 2 == 0) {
                answer.append(Character.toUpperCase(s.charAt(i)));
            } else {
                answer.append(s.charAt(i));
            }
            idx++;
        }

        return answer.toString();
    }
}