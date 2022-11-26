package kakao.mobi221126.savemoney;

/**
 * 시분초 계산해서 times+1개의 원소 확보
 * 실패/성공 = 0/1 -> return[0]
 * 마지막날 - 첫날 + 1 -> return[1]
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    String[] input;
    Set<String> comparing;
    int g;

    public int[] solution(String s, String[] times) {
        g = times.length + 1;
        input = new String[g];
        input[0] = s;

        for (int i = 0; i < times.length; i++) {
            input[i + 1] = makeInput(i, times[i]);
        }

        int[] answer = {0, 0};
        answer[1] = solveAnswer1();

        for (int i = 0; i < input.length; i++) {
            input[i] = input[i].substring(0, 10);
        }

        comparing = new HashSet<>(Arrays.asList(input));
        if (comparing.size() == answer[1]) {
            answer[0] = 1;
        }

        return answer;
    }

    private int solveAnswer1() {
        String[] tmp = input[0].split(":");
        int[] startDay = new int[6];
        for (int i = 0; i < 6; i++) {
            startDay[i] = Integer.parseInt(tmp[i]);
        }

        tmp = input[g - 1].split(":");
        int[] endDay = new int[6];
        for (int i = 0; i < 6; i++) {
            endDay[i] = Integer.parseInt(tmp[i]);
        }

        while (startDay[0] != endDay[0]) {
            endDay[0]--;
            endDay[1] += 12;
        }

        while (startDay[1] != endDay[1]) {
            endDay[1]--;
            endDay[2] += 30;
        }

        return endDay[2] - startDay[2] + 1;
    }


    private String makeInput(int idx, String time) {
        String[] point = input[idx].split(":");
        String[] move = time.split(":");
        int[] result = new int[6];

        for (int i = 0; i < 6; i++) {
            result[i] = Integer.parseInt(point[i]);

            if (i < 2) {
                continue;
            }

            result[i] += Integer.parseInt(move[i - 2]);
        }

        while (result[5] >= 60) {
            result[5] -= 60;
            result[4]++;
        }

        while (result[4] >= 60) {
            result[4] -= 60;
            result[3]++;
        }

        while (result[3] >= 24) {
            result[3] -= 24;
            result[2]++;
        }

        while (result[2] > 30) {
            result[2] -= 30;
            result[1]++;
        }

        while (result[1] > 12) {
            result[1] -= 12;
            result[0]++;
        }

        StringBuilder outfit = new StringBuilder();
        for (int i = 0; i < point.length; i++) {
            int tmp = result[i];
            if (tmp < 10) {
                outfit.append(0);
            }
            outfit.append(tmp);
            if (i < 5) {
                outfit.append(":");
            }
        }

        return outfit.toString();
    }

}