package bdalgoclass.exercises.x04.boj1406;

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String first = br.readLine();
        int idx = first.length();

        Stack<Character> lStack = new Stack<>();
        Stack<Character> rStack = new Stack<>();
        for (int i = 0; i < idx; i++) {
            lStack.add(first.charAt(i));
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            char[] order = br.readLine().toCharArray();

            if (order[0] == 'L') {
                if (!lStack.isEmpty()) {
                    rStack.add(lStack.pop());
                }
                continue;
            }

            if (order[0] == 'D') {
                if (!rStack.isEmpty()) {
                    lStack.add(rStack.pop());
                }
                continue;
            }

            if (order[0] == 'B') {
                if (!lStack.isEmpty()) {
                    lStack.pop();
                }
                continue;
            }

            lStack.add(order[2]);
        }

        while (!lStack.isEmpty()) {
            rStack.add(lStack.pop());
        }

        StringBuilder sb = new StringBuilder();
        while (!rStack.isEmpty()) {
            sb.append(rStack.pop());
        }
        System.out.println(sb);

    }
}