package bdalgoclass.exercises.x0C.boj1941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static char[][] gyosil = new char[5][5];
    static boolean[][] pickedChair = new boolean[5][5];
    static Pair firstPrincess = new Pair(5, 5);
    static boolean[] binaryFlag = new boolean[25];
    static Set<String> result = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            gyosil[i] = br.readLine().toCharArray();

            Arrays.fill(pickedChair[i], false);
        }

        Arrays.fill(binaryFlag, false);
        makeCrew(0, 0, 0);

        System.out.println(result.size());
    }

    private static void makeCrew(int idx, int start, int yCount) {
        if (yCount >= 4) {
            return;
        }

        if (idx == 7) {
            if (validCrew()) {
                result.add(flagToString(binaryFlag));
            }
            return;
        }


        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (!pickedChair[i][j]) {
                    if (idx == 0) {
                        firstPrincess = new Pair(i, j);
                    }
                    pickedChair[i][j] = true;
                    binaryFlag[(i * 5) + j] = true;
                    if (gyosil[i][j] == 'Y') {
                        yCount++;
                    }

                    makeCrew(idx + 1);

                    pickedChair[i][j] = false;
                    binaryFlag[(i * 5) + j] = false;
                    if (gyosil[i][j] == 'Y') {
                        yCount--;
                    }
                }
            }
        }
    }

    private static String flagToString(boolean[] binaryFlag) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < binaryFlag.length; i++) {
            if (binaryFlag[i]) {
                sb.append(1);
            } else {
                sb.append(0);
            }
        }
        return sb.toString();
    }

    private static boolean validCrew() {
        Queue<Pair> queue = new LinkedList<>();
        int[][] depth = new int[5][5];
        for (int i = 0; i < 5; i++) {
            Arrays.fill(depth[i], 0);
        }
        int mx = 0;

        queue.add(firstPrincess);
        depth[firstPrincess.x][firstPrincess.y] = 1;
        while (!queue.isEmpty()) {
            Pair now = queue.remove();
            int nowDepth = depth[now.x][now.y];

            int[] xSeek = {1, 0, -1, 0};
            int[] ySeek = {0, 1, 0, -1};
            for (int i = 0; i < 4; i++) {
                int xTmp = now.x + xSeek[i];
                int yTmp = now.y + ySeek[i];

                if (invalidIndex(xTmp, yTmp)) {
                    continue;
                }

                if (depth[xTmp][yTmp] > 0) {
                    continue;
                }

                if (pickedChair[xTmp][yTmp]) {
                    queue.add(new Pair(xTmp, yTmp));
                    depth[xTmp][yTmp] = nowDepth + 1;

                    mx = Math.max(nowDepth + 1, mx);
                }
            }
        }

        return mx == 7;
    }

    private static boolean invalidIndex(int x, int y) {
        return x < 0 || x >= 5
                || y < 0 || y >= 5;
    }
}

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}