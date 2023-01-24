package bdalgoclass.exercises.x09.boj7576;

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
        int tmp = nm[0];
        nm[0] = nm[1];
        nm[1] = tmp;

        int[][] arr = new int[nm[0]][nm[1]];
        boolean[][] flag = new boolean[nm[0]][nm[1]];
        Queue<Pair> queue = new LinkedList<>();
        tmp = 0;

        for (int i = 0; i < nm[0]; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray().clone();

            Arrays.fill(flag[i], false);

            for (int j = 0; j < nm[1]; j++) {
                if (arr[i][j] == 1) {
                    queue.add(new Pair(i, j));
                    continue;
                }
                if (arr[i][j] == 0) {
                    tmp++;
                }
            }
        }

        if (tmp == 0) {
            System.out.println(0);
            return;
        }

        int[] xSeek = {1, 0, -1, 0};
        int[] ySeek = {0, 1, 0, -1};
        while (!queue.isEmpty()) {

            Pair now = queue.remove();

            for (int i = 0; i < 4; i++) {

                int xTmp = now.x + xSeek[i];
                int yTmp = now.y + ySeek[i];

                if (wrongRange(xTmp, nm[0])
                        || wrongRange(yTmp, nm[1])) {
                    continue;
                }

                //원래 bfs조건(벽이 아닌지) <arr(x,y) == -1>
                // ++ 큐에 대기하고 있지만 사방탐색으로 먼저 도달해버린경우 무시 <arr(x,y) >= 1>
                if (flag[xTmp][yTmp] == true
                        || arr[xTmp][yTmp] != 0) {
                    continue;
                }

                queue.add(new Pair(xTmp, yTmp));
                flag[xTmp][yTmp] = true;
                arr[xTmp][yTmp] = arr[now.x][now.y] + 1;
            }
        }

        int result = 0;
        for (int i = 0; i < nm[0]; i++) {
            for (int j = 0; j < nm[1]; j++) {

                if (arr[i][j] == -1) {
                    continue;
                }

                if (arr[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }

                result = Math.max(result, arr[i][j]);
            }
        }

        //1일차로부터 며칠이 지나면 다익는지
        System.out.println(result - 1);
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