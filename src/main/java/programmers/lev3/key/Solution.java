package programmers.lev3.key;

import java.util.Arrays;

class Solution {

    int[][] bigmap;
    int lockLength;

    public boolean solution(int[][] key, int[][] lock) {

        lockLength = lock.length;
        int bigLen = lock.length + (key.length * 2) - 2;
        bigmap = new int[bigLen][bigLen];
        for (int i = 0; i < bigLen; i++) {
            Arrays.fill(bigmap[i], 0);
        }

        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock.length; j++) {
                bigmap[i + key.length - 1][j + key.length - 1] = lock[i][j];
            }
        }


        for (int i = 0; i < 4; i++) {
            int[][] nowKey = keySpin(key, i);

            for (int x = 0; x < bigLen - key.length + 1; x++) {
                for (int y = 0; y < bigLen - key.length + 1; y++) {
                    if (unlock(nowKey, x, y)) {
                        return true;
                    }
                }
            }

        }

        return false;
    }

    private boolean unlock(int[][] key, int xKeyStart, int yKeyStart) {
        boolean result = true;

        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                bigmap[i + xKeyStart][j + yKeyStart] += key[i][j];
            }
        }

        //검증
        for (int i = 0; i < lockLength; i++) {
            for (int j = 0; j < lockLength; j++) {
                int tmp = bigmap[i + key.length - 1][j + key.length - 1];
                if (tmp > 1 || tmp == 0) {
                    result = false;
                    break;
                }
            }
        }


        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                bigmap[i + xKeyStart][j + yKeyStart] -= key[i][j];
            }
        }

        return result;
    }

    private int[][] keySpin(int[][] key, int step) {
        if (step == 0) {
            return key;
        }

        int[][] result = new int[key.length][key.length];
        for (int i = 0; i < key.length; i++) {

            int[] tmp = new int[key.length];
            for (int j = 0; j < key.length; j++) {
                tmp[j] = key[key.length - j - 1][i];
            }

            result[i] = tmp.clone();
        }

        return keySpin(result, step - 1);
    }
}