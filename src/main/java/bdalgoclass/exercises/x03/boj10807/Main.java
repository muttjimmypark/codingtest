package bdalgoclass.exercises.x03.boj10807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();

        int[] arr = new int[201];
        Arrays.fill(arr, 0);
        Arrays.stream(br.readLine().split(" "))
                .forEach(e -> arr[Integer.parseInt(e) + 100]++);

        System.out.println(arr[Integer.parseInt(br.readLine()) + 100]);
    }
}