package bdalgoclass.exercises.x05.boj10773;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < k; i++) {
            int tmp = Integer.parseInt(br.readLine());

            if (tmp == 0) {
                stack.pop();
                continue;
            }

            stack.add(tmp);
        }

        k = 0;
        while (!stack.isEmpty()) {
            k += stack.pop();
        }

        System.out.println(k);
    }
}