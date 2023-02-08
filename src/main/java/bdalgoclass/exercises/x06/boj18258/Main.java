package bdalgoclass.exercises.x06.boj18258;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] queue = new int[2000001];
        int head = 0;
        int tail = 0;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] order = br.readLine().split(" ");

            if (order[0].equals("push")) {
                queue[tail++] = Integer.parseInt(order[1]);
                continue;
            }

            if (order[0].equals("pop")) {
                if (tail > head) {
                    sb.append(queue[head++]).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
                continue;
            }

            if (order[0].equals("size")) {
                sb.append(tail - head).append("\n");
                continue;
            }

            if (order[0].equals("empty")) {
                sb.append(tail == head ? 1 : 0).append("\n");
                continue;
            }

            if (order[0].equals("front")) {
                if (tail > head) {
                    sb.append(queue[head]).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
                continue;
            }

            if (order[0].equals("back")) {
                if (tail > head) {
                    sb.append(queue[tail - 1]).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}