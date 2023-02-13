package bdalgoclass.exercises.x0D.boj15683;

/**
 * 230213
 * 1320 - 1404
 * 1410 - 1452
 * 86m
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[][] office;
    static int[][] camSpot;
    static int camCount;
    static int wallCount;
    static int[][] view;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        office = new int[n][m];
        camSpot = new int[8][2];
        camCount = 0;
        wallCount = 0;
        view = new int[n][m];

        for (int i = 0; i < n; i++) {
            office[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int j = 0; j < m; j++) {
                if (office[i][j] > 0
                        && office[i][j] < 6) {
                    camSpot[camCount][0] = i;
                    camSpot[camCount++][1] = j;
                }
                if (office[i][j] == 6) {
                    wallCount++;
                }
            }

            Arrays.fill(view[i], 0);
        }

        result = n * m;
        howInstall(0);

        System.out.println(result);
    }

    private static void howInstall(int idx) {
        if (idx == camCount) {
            checkView();
            return;
        }

        int xNow = camSpot[idx][0];
        int yNow = camSpot[idx][1];
        int camType = office[xNow][yNow];

        if (camType == 1) {
            char[] a = {'r', 'u', 'l', 'd'};
            for (int i = 0; i < 4; i++) {
                paintingView(xNow, yNow, a[i]);

                howInstall(idx + 1);

                rollbackView(xNow, yNow, a[i]);
            }
            return;
        }

        if (camType == 2) {
            char[] a = {'r', 'u'};
            char[] b = {'l', 'd'};
            for (int i = 0; i < 2; i++) {
                paintingView(xNow, yNow, a[i]);
                paintingView(xNow, yNow, b[i]);

                howInstall(idx + 1);

                rollbackView(xNow, yNow, a[i]);
                rollbackView(xNow, yNow, b[i]);
            }
            return;
        }

        if (camType == 3) {
            char[] a = {'r', 'u', 'l', 'd'};
            char[] b = {'u', 'l', 'd', 'r'};
            for (int i = 0; i < 4; i++) {
                paintingView(xNow, yNow, a[i]);
                paintingView(xNow, yNow, b[i]);

                howInstall(idx + 1);

                rollbackView(xNow, yNow, a[i]);
                rollbackView(xNow, yNow, b[i]);
            }
            return;
        }

        if (camType == 4) {
            paintingView(xNow, yNow, 'r');
            paintingView(xNow, yNow, 'u');
            paintingView(xNow, yNow, 'l');
            paintingView(xNow, yNow, 'd');
            char[] a = {'r', 'u', 'l', 'd'};
            for (int i = 0; i < 4; i++) {
                rollbackView(xNow, yNow, a[i]);

                howInstall(idx + 1);

                paintingView(xNow, yNow, a[i]);
            }

            rollbackView(xNow, yNow, 'r');
            rollbackView(xNow, yNow, 'u');
            rollbackView(xNow, yNow, 'l');
            rollbackView(xNow, yNow, 'd');
            return;
        }

        if (camType == 5) {
            paintingView(xNow, yNow, 'r');
            paintingView(xNow, yNow, 'u');
            paintingView(xNow, yNow, 'l');
            paintingView(xNow, yNow, 'd');

            howInstall(idx + 1);

            rollbackView(xNow, yNow, 'r');
            rollbackView(xNow, yNow, 'u');
            rollbackView(xNow, yNow, 'l');
            rollbackView(xNow, yNow, 'd');
        }
    }

    private static void paintingView(int x, int y, char way) {
        // 벽 도달 or idx초과하면 완료

        if (way == 'r') {
            for (int i = 0; i < 8; i++) {
                if (y + i >= m) {
                    return;
                }

                if (office[x][y + i] == 6) {
                    return;
                }

                view[x][y + i]++;
            }
            return;
        }

        if (way == 'l') {
            for (int i = 0; i < 8; i++) {
                if (y - i < 0) {
                    return;
                }

                if (office[x][y - i] == 6) {
                    return;
                }

                view[x][y - i]++;
            }
            return;
        }

        if (way == 'u') {
            for (int i = 0; i < 8; i++) {
                if (x - i < 0) {
                    return;
                }

                if (office[x - i][y] == 6) {
                    return;
                }

                view[x - i][y]++;
            }
            return;
        }

        if (way == 'd') {
            for (int i = 0; i < 8; i++) {
                if (x + i >= n) {
                    return;
                }

                if (office[x + i][y] == 6) {
                    return;
                }

                view[x + i][y]++;
            }
        }
    }

    private static void rollbackView(int x, int y, char way) {
        // 벽 도달 or idx초과하면 완료

        if (way == 'r') {
            for (int i = 0; i < 8; i++) {
                if (y + i >= m) {
                    return;
                }

                if (office[x][y + i] == 6) {
                    return;
                }

                view[x][y + i]--;
            }
            return;
        }

        if (way == 'l') {
            for (int i = 0; i < 8; i++) {
                if (y - i < 0) {
                    return;
                }

                if (office[x][y - i] == 6) {
                    return;
                }

                view[x][y - i]--;
            }
            return;
        }

        if (way == 'u') {
            for (int i = 0; i < 8; i++) {
                if (x - i < 0) {
                    return;
                }

                if (office[x - i][y] == 6) {
                    return;
                }

                view[x - i][y]--;
            }
            return;
        }

        if (way == 'd') {
            for (int i = 0; i < 8; i++) {
                if (x + i >= n) {
                    return;
                }

                if (office[x + i][y] == 6) {
                    return;
                }

                view[x + i][y]--;
            }
        }
    }

    private static void checkView() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (view[i][j] == 0) {
                    count++;
                }
            }
        }
        result = Math.min(result, count - wallCount);
    }
}