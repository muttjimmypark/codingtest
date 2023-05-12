package programmers.lev2.jadencase;

class Solution {
    public String solution(String s) {

        StringBuilder sb = new StringBuilder();
        int slen = s.length();
        char ap = 0;
        char now = 0;
        for (int i = 0; i < slen; i++) {
            ap = now;
            now = s.charAt(i);

            if (now >= '0' && now <= '9') {
                sb.append(now);
                continue;
            }

            if (i == 0 || ap == ' ') {
                sb.append(Character.toUpperCase(now));
                continue;
            }

            sb.append(Character.toLowerCase(now));
        }

        return sb.toString();
    }
}