package bdalgoclass.exercises.x08.boj2504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Stack<Character> stack = new Stack<>();

        int result = 0;
        int tmp = 1;
        boolean nodap = false;
        for (int i = 0; i < input.length(); i++) {
            char now = input.charAt(i);
            char ap = 0;
            if (i > 0) {
                ap = input.charAt(i - 1);
            }

            if (now == '(') {
                tmp *= 2;
                stack.add(now);
                continue;
            }

            if (now == '[') {
                tmp *= 3;
                stack.add(now);
                continue;
            }

            if (now == ')') {
                if (stack.isEmpty()
                        || stack.pop() == '[') {
                    nodap = true;
                    break;
                }

                if (ap == '(') {
                    result += tmp;
                }
                tmp /= 2;
                continue;
            }

            if (now == ']') {
                if (stack.isEmpty()
                        || stack.pop() == '(') {
                    nodap = true;
                    break;
                }

                if (ap == '[') {
                    result += tmp;
                }
                tmp /= 3;
            }
        }

        if (nodap || !stack.isEmpty()) {
            result = 0;
        }

        System.out.println(result);
    }
}