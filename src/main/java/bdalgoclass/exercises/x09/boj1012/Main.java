package bdalgoclass.exercises.x09.boj1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int count = 0;
            boolean[][] arr = new boolean[m][n];
            boolean[][] flag = new boolean[m][n];
            for (int j = 0; j < m; j++) {
                Arrays.fill(arr[j], false);
                Arrays.fill(flag[j], false);

            }

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                arr[x][y] = true;
            }

            Queue<Pair> queue = new LinkedList<>();
            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {
                    if (arr[x][y]
                            && !flag[x][y]) {
                        queue.add(new Pair(x, y));
                        flag[x][y] = true;

                        while (!queue.isEmpty()) {
                            Pair now = queue.remove();

                            int[] xSeek = {1, 0, -1, 0};
                            int[] ySeek = {0, 1, 0, -1};

                            for (int j = 0; j < 4; j++) {
                                int xTmp = now.x + xSeek[j];
                                int yTmp = now.y + ySeek[j];

                                if (invalidRange(xTmp, m)
                                        || invalidRange(yTmp, n)) {
                                    continue;
                                }

                                if (!arr[xTmp][yTmp]
                                        || flag[xTmp][yTmp]) {
                                    continue;
                                }

                                queue.add(new Pair(xTmp, yTmp));
                                flag[xTmp][yTmp] = true;
                            }
                        }

                        count++;
                    }
                }
            }

            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean invalidRange(int idx, int mx) {
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