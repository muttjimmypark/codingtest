package bdalgoclass.exercises.x09.boj2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nm = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] arr = new int[nm[0]][nm[1]];
        boolean[][] flag = new boolean[nm[0]][nm[1]];
        for (int i = 0; i < nm[0]; i++) {
            String input = br.readLine();
            for (int j = 0; j < nm[1]; j++) {
                arr[i][j] = input.charAt(j) - '0';
            }

            Arrays.fill(flag[i], false);
        }

        Queue<Pair> queue = new LinkedList<>();
        int[] xSeek = {1, 0, -1, 0};
        int[] ySeek = {0, 1, 0, -1};
        queue.add(new Pair(0, 0));
        flag[0][0] = true;

        while (!queue.isEmpty()) {
            Pair now = queue.remove();

            for (int i = 0; i < 4; i++) {
                int xTmp = now.x + xSeek[i];
                int yTmp = now.y + ySeek[i];

                if (wrongRange(xTmp, nm[0])
                        || wrongRange(yTmp, nm[1])) {
                    continue;
                }

                if (flag[xTmp][yTmp] == true
                        || arr[xTmp][yTmp] != 1) {
                    continue;
                }

                queue.add(new Pair(xTmp, yTmp));
                flag[xTmp][yTmp] = true;
                arr[xTmp][yTmp] = arr[now.x][now.y] + 1;
            }
        }

        System.out.println(arr[nm[0] - 1][nm[1] - 1]);
    }

    private static boolean wrongRange(int idx, int mx) {
        return idx < 0
                || idx >= mx;
    }
}

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}