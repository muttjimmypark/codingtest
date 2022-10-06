package kakao.archer2022;

//1632-1712 stackoverflow

import java.util.Arrays;
import java.util.Scanner;

class Solution2 {
    static int gn;
    static int[] ginfo;
    static int[] answer;

    public static int[] solution(int n, int[] info) {
        gn = n;
        ginfo = info.clone();
        answer = new int[11];
        Arrays.fill(answer, 0);

        int enemyScore = 0;
        for (int i = 0; i < info.length; i++) {
            if (info[i] > 0) {
                enemyScore += (10 - i);
            }
        }

        int myScore = solve(n, 0);

        if (enemyScore >= myScore) {
            return new int[]{-1};
        }
        return answer;
    }

    private static int solve(int shot, int index) {
        if (index == 10) {
            answer[index] = shot;
            return 0;
        }
        if (shot == 0) {
            return 0;
        }

        int winNow = (10 - index) + solve(shot - (ginfo[index] + 1), index++);
        int loseNow = solve(shot, index++);

        if (winNow > loseNow) {
            answer[index] = ginfo[index] + 1;
            return winNow;
        }
        return loseNow;
    }

    public static void main(String[] args) {
        System.out.print("input n : ");
        int n = new Scanner(System.in).nextInt();

        int[] info = new int[11];
        for (int i = 0; i < 11; i++) {
            System.out.print("input info[" + i + "] : ");
            info[i] = new Scanner(System.in).nextInt();
        }

        int[] result = solution(n, info);
        System.out.println("result = " + Arrays.toString(result));
    }
}