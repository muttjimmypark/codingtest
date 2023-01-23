package bdalgoclass.exercises.x02.boj2441;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                if (i <= j) {
                    sb.append("*");
                    continue;
                }
                sb.append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);

    }
}