package bdalgoclass.exercises.x09.boj10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static char[][] arr;
    static boolean[][] blueFlag;
    static boolean[][] rgFlag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new char[n][n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
            Arrays.fill(blueFlag[i], false);
            Arrays.fill(rgFlag[i], false);
        }

    }
}
