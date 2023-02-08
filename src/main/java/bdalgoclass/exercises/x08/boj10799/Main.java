package bdalgoclass.exercises.x08.boj10799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int leftCount = 1;
        int pieces = 0;

        for (int i = 1; i < input.length(); i++) {
            char ap = input.charAt(i - 1);
            char now = input.charAt(i);

            if (now == '(') {
                leftCount++;
                continue;
            }

            if (now == ')'
                    && ap == '(') {
                leftCount = Math.max(0, leftCount - 1);
                pieces += leftCount;
                continue;
            }

            if (now == ')'
                    && ap == ')') {
                leftCount = Math.max(0, leftCount - 1);
                pieces++;
            }
        }

        System.out.println(pieces);
    }
}