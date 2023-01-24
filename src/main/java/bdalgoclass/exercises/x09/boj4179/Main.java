package bdalgoclass.exercises.x09.boj4179;

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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[][] arr = new int[r][c];
        int[][] ji = new int[r][c];
        boolean[][] jFlag = new boolean[r][c];
        int[][] fire = new int[r][c];
        boolean[][] fFlag = new boolean[r][c];
        Queue<Pair> q = new LinkedList<>();
        Pair jStart = new Pair(-1, -1);

        for (int i = 0; i < r; i++) {
            String tmp = br.readLine();

            for (int j = 0; j < c; j++) {
                arr[i][j] = tmp.charAt(j);

                if (arr[i][j] == 'F') {
                    q.add(new Pair(i, j));
                }

                if (arr[i][j] == 'J') {
                    jStart = new Pair(i, j);
                }
            }

            Arrays.fill(jFlag[i], false);
            Arrays.fill(fFlag[i], false);
            Arrays.fill(ji[i], 0);
            Arrays.fill(fire[i], 0);
        }

        int[] xSeek = {1, 0, -1, 0};
        int[] ySeek = {0, 1, 0, -1};

        if (q.isEmpty()) {
            //주어진 지도에 불난곳이 없으면 fireArray 검증을 무력화
            for (int i = 0; i < r; i++) {
                Arrays.fill(fire[i], Integer.MAX_VALUE);
            }
        } else {
            fFlag[q.peek().x][q.peek().y] = true;
        }
        while (!q.isEmpty()) {
            Pair now = q.remove();

            for (int i = 0; i < 4; i++) {
                int xTmp = now.x + xSeek[i];
                int yTmp = now.y + ySeek[i];

                if (invalidIndex(xTmp, r)
                        || invalidIndex(yTmp, c)) {
                    continue;
                }

                if (arr[xTmp][yTmp] != '.'
                        || fFlag[xTmp][yTmp]) {
                    continue;
                }

                q.add(new Pair(xTmp, yTmp));
                fFlag[xTmp][yTmp] = true;

                fire[xTmp][yTmp] = fire[now.x][now.y] + 1;
            }
        }

        q.add(jStart);
        jFlag[jStart.x][jStart.y] = true;
        while (!q.isEmpty()) {
            Pair now = q.remove();
            int nextStep = ji[now.x][now.y] + 1;

            for (int i = 0; i < 4; i++) {
                int xTmp = now.x + xSeek[i];
                int yTmp = now.y + ySeek[i];

                if (invalidIndex(xTmp, r)
                        || invalidIndex(yTmp, c)) {
                    System.out.println(nextStep);
                    return;
                }

                if (arr[xTmp][yTmp] != '.'
                        || jFlag[xTmp][yTmp]
                        || nextStep >= fire[xTmp][yTmp]) {
                    continue;
                }

                q.add(new Pair(xTmp, yTmp));
                jFlag[xTmp][yTmp] = true;

                ji[xTmp][yTmp] = nextStep;
            }
        }

        System.out.println("IMPOSSIBLE");
    }


    private static boolean invalidIndex(int idx, int mx) {
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