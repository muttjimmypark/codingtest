package kakao.archer2022;

//221006
//1355-1416 21
//1433-1523 50
// 반례 : 항상 가장 중심으로 맞춰야 최선이 아니다
//      입력값 〉	9, [0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1]
//      기댓값 〉	[1, 1, 2, 0, 1, 2, 2, 0, 0, 0, 0]
//      실행 결과 〉	실행한 결괏값 [1,1,2,3,1,0,0,0,0,0,1]이 기댓값 [1,1,2,0,1,2,2,0,0,0,0]과 다릅니다.


import java.util.Arrays;

class Solution1 {
    int gn;
    int[] gInfo;

    public int[] solution(int n, int[] info) {
        gn = n;
        gInfo = info.clone();
        int winScore = 0;
        int[] answer = new int[11];

        for (int i = 0; i < 11; i++) {
            int[] myTmp = makeBest(i);
            int myScore = getScore(myTmp);

            int[] enemyTmp = enemyDamage(myTmp);
            int enemyScore = getScore(enemyTmp);

            if (myScore > enemyScore) {
                if (myScore >= winScore) {
                    winScore = myScore;
                    answer = myTmp.clone();
                }
            }
        }

        if (winScore == 0) {
            return new int[]{-1};
        }
        return answer;
    }

    private int[] makeBest(int startIndex) {
        int[] result = new int[11];
        Arrays.fill(result, 0);
        int shot = gn;

        for (int i = 0; i < result.length; i++) {
            if (i < startIndex) {
                continue;
            }

            if (shot > gInfo[i]) {
                result[i] = gInfo[i] + 1;
                shot -= result[i];
            }

            if (shot == 0) {
                break;
            }
        }

        if (shot > 0) {
            result[10] = shot;
        }
        return result;
    }

    private int[] enemyDamage(int[] myInfo) {
        int[] result = gInfo.clone();

        for (int i = 0; i < result.length; i++) {
            if (myInfo[i] > result[i]) {
                result[i] = 0;
            }
        }

        return result;
    }

    private int getScore(int[] input) {
        int result = 0;

        for (int i = 0; i < input.length; i++) {
            if (input[i] > 0) {
                result += (10 - i);
            }
        }

        return result;
    }
}