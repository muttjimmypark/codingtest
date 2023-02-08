package bdalgoclass.exercises.x05.boj2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Stack<Pair> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int now = Integer.parseInt(st.nextToken());

            while (true) {
                if (stack.isEmpty()) {
                    sb.append(0).append(" ");
                    stack.add(new Pair(i, now));
                    break;
                }

                if (stack.peek().height < now) {
                    stack.pop();
                    continue;
                }

                sb.append(stack.peek().index).append(" ");
                stack.add(new Pair(i, now));
                break;
            }
        }

        System.out.println(sb);
    }
}

class Pair {
    int index, height;

    public Pair(int index, int height) {
        this.index = index;
        this.height = height;
    }
}