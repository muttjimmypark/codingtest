package bdalgoclass.exercises.x08.boj3986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            Stack<Character> stack = new Stack<>();

            for (int j = 0; j < input.length(); j++) {
                char now = input.charAt(j);

                if (stack.isEmpty()) {
                    stack.add(now);
                    continue;
                }

                if (stack.peek() != now) {
                    stack.add(now);
                    continue;
                }

                stack.pop();
            }

            if (stack.isEmpty()) {
                count++;
            }

        }

        System.out.println(count);
    }
}