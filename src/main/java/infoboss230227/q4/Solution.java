package infoboss230227.q4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    int inputRowCount;
    int[] count;
    int[] where;

    public String[] solution(String[] card, String[] word) {

        inputRowCount = card.length;
        count = new int[26];
        where = new int[26];
        Arrays.fill(count, 0);
        Arrays.fill(where, -1);

        //카드가 몇개있으며, 그 카드가 어느줄에 있는지 정리
        for (int i = 0; i < card.length; i++) {
            for (int j = 0; j < card[i].length(); j++) {
                int idx = card[i].charAt(j) - 'A';
                count[idx]++;
                where[idx] = i;
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < word.length; i++) {
            if (validWord(word[i])) {
                result.add(word[i]);
            }
        }

        if (result.size() == 0) {
            return new String[]{"-1"};
        }

        return result.toArray(new String[0]);
    }

    private boolean validWord(String s) {

        boolean[] checkRow = new boolean[inputRowCount];
        Arrays.fill(checkRow, false);

        int[] tmpCount = new int[26];
        Arrays.fill(tmpCount, 0);

        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            int nowIdx = now - 'A';

            //아예 없으면 false
            if (count[nowIdx] == 0) {
                return false;
            }

            tmpCount[nowIdx]++;
            checkRow[where[nowIdx]] = true;

            //갯수 모자라면 false
            if (count[nowIdx] < tmpCount[nowIdx]) {
                return false;
            }

        }

        // 모든줄에서 사용하지 않았으면 false
        for (int i = 0; i < inputRowCount; i++) {
            if (!checkRow[i]) {
                return false;
            }
        }

        return true;
    }
}