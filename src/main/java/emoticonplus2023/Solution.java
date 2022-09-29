package emoticonplus2023;

import java.util.Arrays;

class Solution {

    int[][] gUsers;
    int[] gEmo;

    public int[] solution(int[][] users, int[] emoticons) {

        gUsers = users.clone();
        gEmo = emoticons.clone();

        int[] dcCase = new int[emoticons.length];
        Arrays.fill(dcCase, 10);

        int[] result = solve(dcCase);
        while (dcCase[0] == 50) {
            dcCase = makeNextCase(dcCase);
            result = compareResult(result, solve(dcCase));
        }

        return result;
    }

    private int[] solve(int[] dcCase) {
        int[] emoAfterDiscount = gEmo.clone();
        for (int i = 0; i < emoAfterDiscount.length; i++) {
            emoAfterDiscount[i] = emoAfterDiscount[i] * dcCase[i] / 100;
        }

        int[] result = {0, 0};

        for (int[] user : gUsers) {
            int tmpBuy = 0;

            for (int i = 0; i < emoAfterDiscount.length; i++) {
                if (dcCase[i] >= user[0]) {
                    tmpBuy += emoAfterDiscount[i];
                }
            }

            if (tmpBuy > user[1]) {
                result[0]++;
                continue;
            }

            result[1] += tmpBuy;
        }

        return result;
    }

    private int[] compareResult(int[] thisResult, int[] nextResult) {
        if (thisResult[0] > nextResult[0]) {
            return thisResult;
        }
        if (thisResult[0] == nextResult[0]
                & thisResult[1] > nextResult[1]) {
            return thisResult;
        }

        return nextResult;
    }

    private int[] makeNextCase(int[] dcCase) {
        int idx = dcCase.length - 1;
        int[] result = dcCase.clone();

        while (idx >= 0) {
            if (result[idx] + 10 <= 40) {
                result[idx] += 10;
                return result;
            }

            result[idx] = 10;
            idx--;
        }

        //경우 다 소진하면 에러경우 리턴
        Arrays.fill(result, 50);
        return result;
    }

}