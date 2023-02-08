package bdalgoclass.exercises.x05.boj1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int next = 1;
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(br.readLine());

            if (now >= next) {
                do {
                    stack.add(next++);
                    sb.append("+").append("\n");
                } while (stack.peek() != now);

                stack.pop();
                sb.append("-").append("\n");
                continue;
            }

            do {
                if (stack.isEmpty()) {
                    System.out.println("NO");
                    return;
                }

                sb.append("-").append("\n");
            } while (stack.pop() != now);
        }

        System.out.println(sb);
    }
}