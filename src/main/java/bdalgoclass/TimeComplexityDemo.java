package bdalgoclass;

import java.util.Arrays;
import java.util.Scanner;

public class TimeComplexityDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("func2 new");

        System.out.print("type N : ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.print("fill arrays with blank : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(func2new(arr));
    }

    private static boolean func2new(int[] arr) {
        boolean[] flag = new boolean[101];
        Arrays.fill(flag, false);

        for (int e : arr) {
            if (flag[100 - e]) {
                return true;
            }

            flag[e] = true;
        }

        return false;

        /**
         * 시간복잡도가 O(N)으로 줄었다
         */
    }

    public static int func1(int n) {
        int result = 0;

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0
                    || i % 5 == 0) {
                result += i;
            }
        }

        return result;

        /**
         * for문 한번 돌리기 -> O(N)
         */
    }

    public static int func2(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == 100) {
                    return 1;
                }
            }
        }
        return 0;

        /**
         * 이중for문 돌리기 -> O(N^2)
         */
    }

    public static int func3(int n) {
        for (int i = 1; i * i <= n; i++) {
            if (i * i == n) {
                return 1;
            }
        }
        return 0;

        /**
         * 1부터 루트N회 탐색되므로 O(루트N)
         */
    }

    public static int func4(int n) {
        int result = 1;
        while (2 * result <= n) {
            result *= 2;
        }
        return result;

        /**
         * N 이하의 수 중에 가장 큰 2의 거듭제곱수 구하기
         *
         * 2^k <= N < 2^(k+1) 일 경우
         * while문은 최대 k회 반복되므로
         * O(k) = O(lgN)
         * (lg4 = 2, lg8 = 3, ...)
         */
    }
}
