package bdalgoclass.exercises.x07.boj10866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] deque = new int[20001];
        Arrays.fill(deque, -2);
        int head = 10000;
        int tail = 10000;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] order = br.readLine().split(" ");

            if (order[0].equals("push_front")) {
                deque[--head] = Integer.parseInt(order[1]);
                continue;
            }

            if (order[0].equals("push_back")) {
                deque[tail++] = Integer.parseInt(order[1]);
                continue;
            }

            if (order[0].equals("pop_front")) {
                if (tail == head) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(deque[head++]).append("\n");
                }
                continue;
            }

            if (order[0].equals("pop_back")) {
                if (tail == head) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(deque[--tail]).append("\n");
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
                if (tail == head) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(deque[head]).append("\n");
                }
                continue;
            }

            if (order[0].equals("back")) {
                if (tail == head) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(deque[tail - 1]).append("\n");
                }
            }

        }

        System.out.println(sb);
    }
}