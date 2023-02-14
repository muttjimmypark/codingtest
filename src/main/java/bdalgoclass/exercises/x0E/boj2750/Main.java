package bdalgoclass.exercises.x0E.boj2750;

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

        sepMerge(0, n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void sepMerge(int start, int end) {
        if (end == start + 1) {
            return;
        }

        int mid = start + ((end - start) / 2);
        sepMerge(start, mid);
        sepMerge(mid, end);

        mergeSort(start, end);
    }

    private static void mergeSort(int start, int end) {
        int[] result = new int[end - start];

        int mid = start + ((end - start) / 2);
        int aIdx = start;
        int bIdx = mid;

        for (int i = 0; i < (end - start); i++) {
            if (aIdx == mid) {
                result[i] = arr[bIdx++];
                continue;
            }

            if (bIdx == end) {
                result[i] = arr[aIdx++];
                continue;
            }

            if (arr[aIdx] <= arr[bIdx]) {
                result[i] = arr[aIdx++];
                continue;
            }

            if (arr[bIdx] < arr[aIdx]) {
                result[i] = arr[bIdx++];
            }
        }

        for (int i = 0; i < (end - start); i++) {
            arr[start + i] = result[i];
        }
    }
}