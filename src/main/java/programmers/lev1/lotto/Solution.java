package programmers.lev1.lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {0, 0};
        int zeroCount = 0;
        int matchCount = 0;
        List<Integer> checkWin = Arrays.stream(win_nums).boxed().collect(Collectors.toList());

        for (int input : lottos) {
            if (input == 0) {
                zeroCount++;
                continue;
            }

            if (checkWin.contains(input)) {
                matchCount++;
            }
        }
        answer[0] = makeRank(matchCount + zeroCount);
        answer[1] = makeRank(matchCount);

        return answer;
    }

    private int makeRank(int i) {
        if (i == 0) {
            return 6;
        }

        return 7 - i;
    }
}