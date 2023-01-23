package bdalgoclass.exercises.x03.boj11328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split(" ");

            if (tmp[0].length() != tmp[1].length()) {
                sb.append("Impossible\n");
                continue;
            }

            char[][] compare = new char[2][tmp[0].length()];
            for (int j = 0; j < compare[0].length; j++) {
                compare[0][j] = tmp[0].charAt(j);
                compare[1][j] = tmp[1].charAt(j);
            }

            Arrays.sort(compare[0]);
            Arrays.sort(compare[1]);

            if (Arrays.equals(compare[0], compare[1])) {
                sb.append("Possible\n");
                continue;
            }
            sb.append("Impossible\n");
        }

        System.out.println(sb);
    }
}