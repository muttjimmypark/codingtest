package bdalgoclass.exercises.x02.boj2752;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        Set<Integer> numbers = new TreeSet<>();

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i += 2) {
            numbers.add(sc.nextInt());
        }

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }
}