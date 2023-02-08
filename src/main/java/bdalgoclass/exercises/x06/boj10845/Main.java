package bdalgoclass.exercises.x06.boj10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] queue = new int[10001];
        Arrays.fill(queue, -2);

        StringBuilder sb = new StringBuilder();
        int head = 0;
        int tail = 0;
        for (int i = 0; i < n; i++) {
            String[] order = br.readLine().split(" ");

            if (order[0].equals("push")) {
                queue[tail++] = Integer.parseInt(order[1]);
                continue;
            }

            if (order[0].equals("pop")) {
                if (head == tail) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(queue[head++]).append("\n");
                }
                continue;
            }

            if (order[0].equals("size")) {
                sb.append(tail - head).append("\n");
                continue;
            }

            if (order[0].equals("empty")) {
                sb.append(tail == head ? 1 : 0).append("\n");
            }

            if (order[0].equals("front")) {
                if (head == tail) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(queue[head]).append("\n");
                }
                continue;
            }

            if (order[0].equals("back")) {
                if (head == tail) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(queue[tail - 1]).append("\n");
                }
            }
        }

        System.out.println(sb);

    }
}