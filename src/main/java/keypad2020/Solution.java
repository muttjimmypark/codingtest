package keypad2020;

//04:50 - 06:10
//19:15 -

import java.util.ArrayList;
import java.util.List;

class Solution {
    int lPosition = 7;
    int rPosition = 9;
    char gHand;
    int[] memo = new int[1 << 9];

    public String solution(int[] numbers, String hand) {
        gHand = hand.toUpperCase().charAt(0);
        StringBuilder answer = new StringBuilder();

        for (int number : numbers) {
            answer.append(findNextFinger(number));
        }
        return answer.toString();
    }

    private char findNextFinger(int number) {
        //번호가 앞순서와 연속된 경우
        if (lPosition == number) {
            return 'L';
        }
        if (rPosition == number) {
            return 'R';
        }

        int divideThree = number % 3;

        //번호가 가운데줄인 경우
        if (divideThree == 2 | number == 0) {
            int lDistance = findDistance(lPosition, number);
            int rDistance = findDistance(rPosition, number);

            if (lDistance == rDistance) {
                if (gHand == 'L') {
                    lPosition = number;
                    return 'L';
                }
                rPosition = number;
                return 'R';
            }

            if (lDistance > rDistance) {
                lPosition = number;
                return 'L';
            }

            rPosition = number;
            return 'R';
        }

        //번호가 한쪽 측면인 경우
        if (divideThree == 1) {
            lPosition = number;
            return 'L';
        }

        if (divideThree == 0) {
            rPosition = number;
            return 'R';
        }

        return 'e';
    }

    private int findDistance(int p1, int p2) {
        //들어오면 안되는 숫자들 처리
        if (p1 < 0 | p1 > 9
                | p2 < 0 | p2 > 9) {
            return 99;
        }
        if (p1 == p2) {
            return 0;
        }
        int orNum = (1 << p1) | (1 << p2);

        //이미 연산한 값 메모불러오기
        if (memo[orNum] != 0) {
            return memo[orNum];
        }

        //0에 접근하려는 경우 처리
        if (p1 == 0) {
            memo[orNum] = findDistance(8, p2) + 1;
            return memo[orNum];
        }
        if (p2 == 0) {
            memo[orNum] = findDistance(p1, 8) + 1;
            return memo[orNum];
        }

        //거리가 1인 경우 판별
        List<Integer> closeNum = new ArrayList<>();
        closeNum.add(p1 - 3);
        closeNum.add(p1 - 1);
        closeNum.add(p1 + 1);
        closeNum.add(p1 + 3);
        if (closeNum.contains(p2)) {
            memo[orNum] = 1;
            return 1;
        }

        //거리가 1 이상인 경우 재귀
        memo[orNum] = closeNum.stream()
                .mapToInt(p -> findDistance(p, p2))
                .min().getAsInt()
                + 1;
        return memo[orNum];
    }
}