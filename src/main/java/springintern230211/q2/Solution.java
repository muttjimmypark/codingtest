package springintern230211.q2;

/**
 * 입력받은 #을 벽으로 인식 + 벽도 면적으로 다 더해놓기
 * bfs로 벽에 둘러쌓인 면적을 합산
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    boolean[][] wallArr;
    boolean[][] flag;
    int height;
    int weight;

    public int solution(String[] grid) {

        int answer = 0;

        height = grid.length;
        weight = grid[0].length();

        wallArr = new boolean[height][weight];
        flag = new boolean[height][weight];

        for (int i = 0; i < height; i++) {
            Arrays.fill(wallArr[i], false);
            Arrays.fill(flag[i], false);

            for (int j = 0; j < weight; j++) {
                if (grid[i].charAt(j) == '#') {
                    wallArr[i][j] = true;
                    answer++;
                }
            }

        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < weight; j++) {


                if (wallArr[i][j]
                        && !flag[i][j]) {

                    Queue<Pair> queue = new LinkedList<>();
                    queue.add(new Pair(i, j));
                    flag[i][j] = true;
                    boolean invalid = false;

                    while (!queue.isEmpty()) {
                        Pair now = queue.remove();

                        int[] xSeek = {1, 0, -1, 0};
                        int[] ySeek = {0, 1, 0, -1};
                        for (int k = 0; k < 4; k++) {
                            int xTmp = now.x + xSeek[i];
                            int yTmp = now.y + ySeek[i];

                            if (invalidIndex(xTmp, yTmp)) {
                                invalid = true;
                                break;
                            }

                            if (flag[xTmp][yTmp]) {
                                continue;
                            }

                            queue.add(new Pair(xTmp, yTmp));
                            flag[xTmp][yTmp] = true;

                        }

                        if (invalid) {

                        }
                    }

                }

            }
        }

        return answer;
    }

    private boolean invalidIndex(int x, int y) {
        return x < 0 || x >= height
                || y < 0 || y >= weight;
    }

}

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
