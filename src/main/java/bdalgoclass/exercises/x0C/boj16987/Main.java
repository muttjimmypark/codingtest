package bdalgoclass.exercises.x0C.boj16987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[][] eggs;
    static boolean[] status;
    static int mx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        eggs = new int[n][2];
        status = new boolean[n];

        for (int i = 0; i < n; i++) {
            eggs[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        Arrays.fill(status, true);

        mx = 0;
        solution(0, 0);

        System.out.println(mx);
    }

    private static void solution(int idx, int broken) {
        if (broken == eggs.length-1) {
            mx = Math.max(mx, broken);
            return;
        }

        if (idx == eggs.length) {
            mx = Math.max(mx, broken);
            return;
        }

        if (!status[idx]) {
            solution(idx + 1, broken);
            return;
        }

        for (int i = 0; i < eggs.length; i++) {

            if (i == idx) {
                continue;
            }

            if (!status[i]) {
                continue;
            }

            int tmp = broken;

            eggs[idx][0] -= eggs[i][1];
            eggs[i][0] -= eggs[idx][1];
            if (eggs[idx][0] <= 0) {
                status[idx] = false;
                tmp++;
            }
            if (eggs[i][0] <= 0) {
                status[i] = false;
                tmp++;
            }

            solution(idx + 1, tmp);

            if (eggs[idx][0] <= 0) {
                status[idx] = true;
            }
            if (eggs[i][0] <= 0) {
                status[i] = true;
            }
            eggs[idx][0] += eggs[i][1];
            eggs[i][0] += eggs[idx][1];
        }
    }
}