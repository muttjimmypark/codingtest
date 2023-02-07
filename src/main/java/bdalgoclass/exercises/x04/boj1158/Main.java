package bdalgoclass.exercises.x04.boj1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int idx = 1;
        int output = 0;
        while (true) {
            int tmp = queue.remove();

            if (idx == k) {
                sb.append(tmp);
                idx = 1;
                output++;

                if (output == n) {
                    sb.append(">");
                    break;
                } else {
                    sb.append(", ");
                }

            } else {
                queue.add(tmp);
                idx++;
            }

        }

        System.out.println(sb);
    }
}