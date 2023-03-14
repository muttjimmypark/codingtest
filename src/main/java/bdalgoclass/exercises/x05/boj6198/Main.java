package bdalgoclass.exercises.x05.boj6198;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        stack.add(Integer.parseInt(br.readLine()));
        long count = 0;
        for (int i = 1; i < n; i++) {
            int now = Integer.parseInt(br.readLine());

            while (!stack.isEmpty()
                    && stack.peek() <= now) {
                stack.pop();
            }
            count += stack.size();
            stack.push(now);
        }

        System.out.println(count);
    }
}