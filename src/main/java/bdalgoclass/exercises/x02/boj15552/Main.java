package bdalgoclass.exercises.x02.boj15552;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int[] nums = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(n -> Integer.parseInt(n))
                    .toArray();

            nums[0] += nums[1];
            sb.append(nums[0] + "\n");
        }

        System.out.println(sb);
    }
}