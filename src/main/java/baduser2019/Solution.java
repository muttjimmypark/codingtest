package baduser2019;

// 02:28 - 03:58
// 04:26 - 06:00

import java.util.*;

class Solution {

    boolean[][] banCases;

    public int solution(String[] user_id, String[] banned_id) {

        banCases = new boolean[banned_id.length][user_id.length];

        for (int i = 0; i < banned_id.length; i++) {
            Arrays.fill(banCases[i], false);

            for (int j = 0; j < user_id.length; j++) {
                if (compareWords(user_id[j], banned_id[i])) {
                    banCases[i][j] = true;
                }
            }

        }

        return solve(0, banned_id.length - 1, 0);

    }

    private boolean compareWords(String user, String ban) {
        if (user.length() != ban.length()) {
            return false;
        }

        for (int i = 0; i < user.length(); i++) {
            if (user.charAt(i) != ban.charAt(i)
                    && ban.charAt(i) != '*') {
                return false;
            }
        }

        return true;
    }

    private int solve(int start, int end, int mark) {
        int result = 0;

        if (start == end) {
            for (int i = 0; i < banCases[end].length; i++) {
                if (banCases[end][i] == true
                        && (mark & (1 << i)) == 0) {
                    result++;
                }
            }
            return result;
        }

        for (int i = 0; i < banCases[start].length; i++) {
            if (banCases[start][i] == true
                    && (mark & (1 << i)) == 0) {
                result += solve(start + 1, end, (mark | (1 << i)));
            }
        }
        return result;
    }

}
