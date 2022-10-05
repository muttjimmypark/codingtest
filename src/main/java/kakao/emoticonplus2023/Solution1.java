package kakao.emoticonplus2023;

import java.util.*;

class Solution1 {

    public int[] solution(int[][] users, int[] emoticons) {

        int everyBuy = 0;
        for (int emoticon : emoticons) {
            everyBuy += emoticon;
        }

        Set<Integer> tmp = new HashSet<>();
        for (int[] user : users) {
            tmp.add(user[0]);
        }
        List<Integer> dcCases = new ArrayList<>();
        for (Integer key : tmp) {
            dcCases.add(key);
        }
        Collections.sort(dcCases);

        //
        int[] answer = {0, 0};

        for (Integer dcCase : dcCases) {
            int tmpUser = 0;
            int tmpEarn = 0;

            for (int[] user : users) {
                int tmpBuy = 0;

                if (dcCase >= user[0]) {
                    tmpBuy = everyBuy * dcCase / 100;
                }

                if (tmpBuy > user[1]) {
                    tmpUser++;
                    continue;
                }

                tmpEarn += tmpBuy;
            }

            if (answer[0] < tmpUser) {
                answer[0] = tmpUser;
                answer[1] = tmpEarn;
            }
            if ((answer[0] == tmpUser)
                    & (answer[1] < tmpEarn)) {
                answer[1] = tmpEarn;
            }
        }

        return answer;
    }
}