package bdalgoclass.exercises.x03.boj1475;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n = br.readLine();

        int[] count = new int[10];
        Arrays.fill(count, 0);

        for (int i = 0; i < n.length(); i++) {
            int tmp = n.charAt(i) - '0';
            count[tmp]++;
        }

        int sixnine = count[6] + count[9];

        if (sixnine % 2 == 1) {
            sixnine /= 2;
            sixnine++;
        } else {
            sixnine /= 2;
        }
        count[6] = sixnine;
        count[9] = 0;

        sixnine = -1;
        for (int i = 0; i < 10; i++) {
            sixnine = Math.max(sixnine, count[i]);
        }
        System.out.println(sixnine);
    }
}