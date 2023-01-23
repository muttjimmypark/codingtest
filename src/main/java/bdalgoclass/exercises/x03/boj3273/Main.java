package bdalgoclass.exercises.x03.boj3273;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        int n = Integer.parseInt(br.readLine());
        br.readLine();

        boolean[] arr = new boolean[1000001];
        Arrays.fill(arr, false);
        Arrays.stream(br.readLine().split(" "))
                .forEach(e -> arr[Integer.parseInt(e)] = true);

        int x = Integer.parseInt(br.readLine());

        int result = 0;
        for (int i = 1; i < 500001; i++) {
            if (i >= x - i
                    || x - i > 1000000) {
                break;
            }

            if (arr[i] && arr[x - i]) {
                result++;
                arr[i] = false;
                arr[x - i] = false;
            }
        }

        System.out.println(result);
    }
}
//public class dead Main {
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//
//        int[] arr = new int[1000001];
//        Arrays.fill(arr, 0);
//        Arrays.stream(br.readLine().split(" "))
//                .forEach(e -> arr[Integer.parseInt(e)]++);
//
//        int x = Integer.parseInt(br.readLine());
//
//        int result = 0;
//        for (int i = 0; i < 500001; i++) {
//            if ((x - i) <= 0) {
//                break;
//            }
//
//            while (arr[i] > 0) {
//                if (arr[x - i] > 0) {
//                    result++;
//                    arr[i]--;
//                    arr[x - i]--;
//                } else {
//                    break;
//                }
//            }
//        }
//
//        System.out.println(result);
//    }
//}