package bdalgoclass.exercises.x03.boj13300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        int[][] students = new int[2][6];
        for (int[] student : students) {
            Arrays.fill(student, 0);
        }

        for (int i = 0; i < input[0]; i++) {
            int[] genGrade = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(e -> Integer.parseInt(e))
                    .toArray();

            students[genGrade[0]][--genGrade[1]]++;
        }

        int rooms = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
                while (students[i][j] > 0) {
                    rooms++;
                    students[i][j] -= input[1];
                }
            }
        }

        System.out.println(rooms);
    }
}