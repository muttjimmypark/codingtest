package bdalgoclass.exercises.x08.boj4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        while (!input.equals(".")) {
            Stack<Character> stack = new Stack<>();
            boolean yn = true;

            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '(') {
                    stack.add('(');
                    continue;
                }

                if (input.charAt(i) == '[') {
                    stack.add('[');
                    continue;
                }

                if (input.charAt(i) == ')') {
                    if (stack.isEmpty()) {
                        yn = false;
                        break;
                    }

                    char tmp = stack.pop();
                    if (tmp != '(') {
                        yn = false;
                        break;
                    }

                    continue;
                }

                if (input.charAt(i) == ']') {
                    if (stack.isEmpty()) {
                        yn = false;
                        break;
                    }

                    char tmp = stack.pop();
                    if (tmp != '[') {
                        yn = false;
                        break;
                    }
                }
            }

            if (!stack.isEmpty()) {
                yn = false;
            }

            sb.append(yn ? "yes" : "no").append("\n");
            input = br.readLine();
        }

        System.out.println(sb);
    }
}