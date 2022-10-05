package kakao.keypad2020;

// 2020 인턴십 - 키패드 누르기
//04:50 - 06:10
//19:15 - 20:45
//02:00 - 03:23 (243m)

public class Solution {
    int lPosition = 30;
    int rPosition = 32;
    char gHand;

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
//        if (lPosition == number) {
//            return 'L';
//        }
//        if (rPosition == number) {
//            return 'R';
//        }

        int divideThree = number % 3;
        int numCode = positionToCode(number);

        //번호가 가운데줄인 경우
        if (divideThree == 2 || number == 0) {
            int lDistance = findDistance(lPosition, numCode);
            int rDistance = findDistance(rPosition, numCode);

            if (lDistance == rDistance) {
                if (gHand == 'L') {
                    lPosition = numCode;
                    return 'L';
                }
                rPosition = numCode;
                return 'R';
            }

            if (lDistance < rDistance) {
                lPosition = numCode;
                return 'L';
            }

            rPosition = numCode;
            return 'R';
        }

        //번호가 한쪽 측면인 경우
        if (divideThree == 1) {
            lPosition = numCode;
            return 'L';
        }

        if (divideThree == 0) {
            rPosition = numCode;
            return 'R';
        }

        return 'e';
    }

    private int findDistance(int p1, int p2) {
        return Math.abs((p1 / 10) - (p2 / 10))
                + Math.abs((p1 % 10) - (p2 % 10));
    }

    private int positionToCode(int position) {
        if (position == 0) {
            return 31;
        }
        return ((position - 1) / 3 * 10) + ((position - 1) % 3);
    }
}