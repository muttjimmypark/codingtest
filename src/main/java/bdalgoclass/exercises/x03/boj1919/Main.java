package bdalgoclass.exercises.x03.boj1919;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] abChar = new int[2][26];
        Arrays.fill(abChar[0], 0);
        Arrays.fill(abChar[1], 0);

        for (int i = 0; i < 2; i++) {
            String tmp = br.readLine();

            for (int j = 0; j < tmp.length(); j++) {
                abChar[i][tmp.charAt(j) - 'a']++;
            }
        }

        int result = 0;
        for (int i = 0; i < 26; i++) {
            result += Math.abs(abChar[0][i] - abChar[1][i]);
        }

        System.out.println(result);
    }
}