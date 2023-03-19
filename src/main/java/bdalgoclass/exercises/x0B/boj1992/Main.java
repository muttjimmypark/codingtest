package bdalgoclass.exercises.x0B.boj1992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static boolean[][] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(sol(0, 0, input));
    }

    private static int sol(int x, int y, boolean[][] input) {

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (input[i][j] )
            }
        }

        return 0;
    }
}
