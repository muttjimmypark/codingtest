package bdalgoclass.exercises.x02.boj2442;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n; j++) {
                if ((n - i) >= j) {
                    sb.append(" ");
                    continue;
                }
                sb.append("*");
            }

            for (int j = 1; j < i; j++) {
                sb.append("*");
            }

            sb.append("\n");
        }

        System.out.println(sb);

    }
}