package zum230203.q4;

import java.util.*;

/**
 * 1. 인접한 숫자들로 bfs 색칠
 * 2. 그 범위 안에 "마름모"가 쏙 들어가는지 확인
 * 3. "마름모"의 최대사이즈와 그 갯수 저장
 * 4. 더큰 "마름모"가 나오면 덮어씌우기
 */

class Solution {

    int mx;
    int[] answer = {1, 0};


    public int[] solution(int[][] grid) {

        mx = grid.length;

        Queue<Pair> queue = new LinkedList<>();
        boolean[][] flag = new boolean[mx][mx];
        for (int i = 0; i < mx; i++) {
            Arrays.fill(flag[i], false);
        }

        for (int x = 0; x < mx; x++) {
            for (int y = 0; y < mx; y++) {

                if (!flag[x][y]) {
                    List<Pair> painted = new ArrayList<>();
                    queue.add(new Pair(x, y));
                    flag[x][y] = true;

                    while (!queue.isEmpty()) {
                        Pair now = queue.remove();

                        int[] xSeek = {1, 0, -1, 0};
                        int[] ySeek = {0, 1, 0, -1};

                        for (int i = 0; i < 4; i++) {
                            int xTmp = now.x + xSeek[i];
                            int yTmp = now.y + ySeek[i];

                            if (invalidAxis(xTmp, yTmp)) {
                                continue;
                            }

                            if (grid[xTmp][yTmp] != grid[now.x][now.y]
                                    || flag[xTmp][yTmp]) {
                                continue;
                            }

                            Pair valid = new Pair(xTmp, yTmp);

                            queue.add(valid);
                            flag[xTmp][yTmp] = true;

                            painted.add(valid);
                        }
                    }

                    if (painted.size() < 4
                            && answer[0] == 1) {
                        answer[1] += painted.size();
                        continue;
                    }

                    if (painted.size() < (answer[0] * answer[0])) {
                        continue;
                    }

                    isMarmmo(painted);
                }
            }
        }

        return answer;
    }

    private void isMarmmo(List<Pair> painted) {
        //최대 뽑아내는 크기가 몇인지 확인하고
        int byun = Math.max(2, answer[0]);


        //answer[0]과 비교해서 적용
        //지금 범위 안에도 같은크기의 마름모가 여러개 있을수 있다
    }

    private boolean invalidAxis(int x, int y) {
        return x < 0 || x >= mx
                || y < 0 || y >= mx;
    }
}

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}