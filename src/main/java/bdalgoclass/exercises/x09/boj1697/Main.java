package bdalgoclass.exercises.x09.boj1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (n == k) {
            System.out.println(0);
            return;
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] arr = new int[100001];
        boolean[] flag = new boolean[100001];
        Arrays.fill(arr, 0);
        Arrays.fill(flag, false);

        queue.add(n);
        flag[n] = true;
        while (!queue.isEmpty()) {
            int now = queue.remove();

            int[] seekIdx = {now - 1, now + 1, now * 2};
            for (int i = 0; i < 3; i++) {
                int tmp = seekIdx[i];

                if (tmp == k) {
                    System.out.println(arr[now] + 1);
                    return;
                }

                if (tmp < 0
                        || tmp > 100000) {
                    continue;
                }

                if (flag[tmp]) {
                    continue;
                }

                queue.add(tmp);
                flag[tmp] = true;

                arr[tmp] = arr[now] + 1;
            }
        }
    }
}