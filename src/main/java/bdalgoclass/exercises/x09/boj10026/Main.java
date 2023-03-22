package bdalgoclass.exercises.x09.boj10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int n;
    static char[][] arr;
    static boolean[][] blueFlag;
    static boolean[][] rgFlag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        blueFlag = new boolean[n][n];
        rgFlag = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
            Arrays.fill(blueFlag[i], false);
            Arrays.fill(rgFlag[i], false);
        }

        int blueCount = 0;
        int notBlueCount = 0;
        int rgCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!blueFlag[i][j]) {
                    if (arr[i][j] == 'B') {
                        blueFlagBfs(i, j, true);
                        blueCount++;
                    } else {
                        blueFlagBfs(i, j, false);
                        notBlueCount++;
                    }
                }

                if (!rgFlag[i][j]) {
                    if (arr[i][j] == 'R') {
                        rgFlagBfs(i, j, 'R');
                        rgCount++;
                    }
                    if (arr[i][j] == 'G') {
                        rgFlagBfs(i, j, 'G');
                        rgCount++;
                    }
                }
            }
        }

        System.out.println((blueCount + rgCount) + " " + (blueCount + notBlueCount));

    }

    private static void blueFlagBfs(int x, int y, boolean mode) {

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y));
        blueFlag[x][y] = true;

        while (!queue.isEmpty()) {
            Pair now = queue.poll();

            int[] xSeek = {1, 0, -1, 0};
            int[] ySeek = {0, 1, 0, -1};
            for (int i = 0; i < 4; i++) {
                int xTmp = now.x + xSeek[i];
                int yTmp = now.y + ySeek[i];

                if (invalidRange(xTmp, yTmp)) {
                    continue;
                }

                if (blueFlag[xTmp][yTmp]
                        || (arr[xTmp][yTmp] == 'B') != mode) {
                    continue;
                }

                queue.add(new Pair(xTmp, yTmp));
                blueFlag[xTmp][yTmp] = true;
            }
        }
    }

    private static void rgFlagBfs(int x, int y, char mode) {

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y));
        rgFlag[x][y] = true;

        while (!queue.isEmpty()) {
            Pair now = queue.poll();

            int[] xSeek = {1, 0, -1, 0};
            int[] ySeek = {0, 1, 0, -1};
            for (int i = 0; i < 4; i++) {
                int xTmp = now.x + xSeek[i];
                int yTmp = now.y + ySeek[i];

                if (invalidRange(xTmp, yTmp)) {
                    continue;
                }

                if (rgFlag[xTmp][yTmp]) {
                    continue;
                }

                if (arr[xTmp][yTmp] == mode) {
                    queue.add(new Pair(xTmp, yTmp));
                    rgFlag[xTmp][yTmp] = true;
                }
            }
        }
    }

    private static boolean invalidRange(int x, int y) {
        return x < 0 || x >= n
                || y < 0 || y >= n;
    }
}

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}