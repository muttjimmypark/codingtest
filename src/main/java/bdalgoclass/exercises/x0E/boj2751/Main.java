package bdalgoclass.exercises.x0E.boj2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        sepAndMerge(0, n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);

    }

    private static void sepAndMerge(int start, int end) {
        if (end == start + 1) {
            return;
        }

        int mid = start + ((end - start) / 2);
        sepAndMerge(start, mid);
        sepAndMerge(mid, end);

        merge(start, end);
    }

    private static void merge(int start, int end) {
        int[] result = new int[end - start];
        int mid = start + ((end - start) / 2);
        int aIdx = start;
        int bIdx = mid;

        for (int i = 0; i < result.length; i++) {
            if (aIdx == mid) {
                result[i] = arr[bIdx];
                bIdx++;
                continue;
            }

            if (bIdx == end) {
                result[i] = arr[aIdx];
                aIdx++;
                continue;
            }

            if (arr[aIdx] < arr[bIdx]) {
                result[i] = arr[aIdx];
                aIdx++;
                continue;
            }

            result[i] = arr[bIdx];
            bIdx++;
        }

        for (int i = 0; i < result.length; i++) {
            arr[i + start] = result[i];
        }
    }

}