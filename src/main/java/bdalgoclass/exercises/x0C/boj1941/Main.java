package bdalgoclass.exercises.x0C.boj1941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static char[][] gyosil;
    static int[] crew;
    static boolean[] visited;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        gyosil = new char[5][5];
        for (int i = 0; i < 5; i++) {
            gyosil[i] = br.readLine().toCharArray();
        }

        crew = new int[7];
        visited = new boolean[7];
        Arrays.fill(crew, 25);
        Arrays.fill(visited, false);

        makeCrew(0, 0, 0);

        System.out.println(result);
    }

    private static void makeCrew(int idx, int start, int yCount) {
        if (yCount > 3) {
            return;
        }

        if (idx == 7) {
            validCrew();
            return;
        }

        for (int i = start; i < 25; i++) {
            crew[idx] = i;

            makeCrew(idx + 1, i + 1,
                    gyosil[i / 5][i % 5] == 'Y' ? yCount + 1 : yCount);
        }
    }

    private static void validCrew() {
        Queue<Pair> queue = new LinkedList<>();

        int count = 1;
        queue.add(new Pair(crew[0] / 5, crew[0] % 5));
        visited[0] = true;

        while (!queue.isEmpty()) {
            Pair now = queue.remove();

            int[] xSeek = {1, 0, -1, 0};
            int[] ySeek = {0, 1, 0, -1};
            for (int i = 0; i < 4; i++) {
                int xTmp = now.x + xSeek[i];
                int yTmp = now.y + ySeek[i];
                int tmp = (xTmp * 5) + yTmp;

                if (invalidIndex(xTmp, yTmp)) {
                    continue;
                }

                for (int j = 0; j < 7; j++) {
                    if (!visited[j]
                            && crew[j] == tmp) {
                        queue.add(new Pair(xTmp, yTmp));
                        visited[j] = true;
                        count++;
                    }
                }
            }
        }

        if (count == 7) {
            result++;
        }
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