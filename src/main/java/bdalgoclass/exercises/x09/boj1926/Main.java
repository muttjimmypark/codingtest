package bdalgoclass.exercises.x09.boj1926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] xMake = {1, 0, -1, 0};
        int[] yMake = {0, 1, 0, -1};

        int[] size = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] arr = new int[size[0]][size[1]];
        boolean[][] flag = new boolean[size[0]][size[1]];
        for (int i = 0; i < size[0]; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray().clone();

            Arrays.fill(flag[i], false);
        }

        int count = 0;
        int biggest = 0;

        for (int i = 0; i < size[0]; i++) {
            for (int j = 0; j < size[1]; j++) {
                if (arr[i][j] != 1
                        || flag[i][j]) {
                    continue;
                }
                count++;

                Queue<Pair> queue = new LinkedList<>();
                flag[i][j] = true;
                queue.add(new Pair(i, j));
                int weight = 1;

                while (!queue.isEmpty()) {
                    Pair now = queue.remove();

                    for (int k = 0; k < 4; k++) {
                        int xTmp = now.x + xMake[k];
                        int yTmp = now.y + yMake[k];

                        if (!rangeCheck(xTmp, size[0])
                                || !rangeCheck(yTmp, size[1])) {
                            continue;
                        }

                        if (arr[xTmp][yTmp] != 1
                                || flag[xTmp][yTmp]) {
                            continue;
                        }

                        queue.add(new Pair(xTmp, yTmp));
                        flag[xTmp][yTmp] = true;
                        weight++;
                    }
                }

                biggest = Math.max(biggest, weight);
            }
        }

        System.out.println(count);
        System.out.println(biggest);
    }

    private static boolean rangeCheck(int idx, int max) {
        return idx >= 0
                && idx < max;
    }
}

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}