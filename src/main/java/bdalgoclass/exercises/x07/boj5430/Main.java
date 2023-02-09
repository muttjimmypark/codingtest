package bdalgoclass.exercises.x07.boj5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {

            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String tmp = br.readLine();

            int[] arr = {};
            if (n != 0) {
                arr = Arrays.stream(tmp.substring(1, tmp.length() - 1).split(","))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }
            int head = 0;
            int tail = n;

            boolean isReverse = false;
            boolean isError = false;
            for (int j = 0; j < p.length(); j++) {
                char order = p.charAt(j);

                if (order == 'R') {
                    isReverse = !isReverse;
                    continue;
                }


                if (tail == head) {
                    isError = true;
                    break;
                }

                if (isReverse) {
                    tail--;
                } else {
                    head++;
                }

            }

            if (isError) {
                sb.append("error").append("\n");
                continue;
            }

            sb.append(arrToString(arr, head, tail, isReverse)).append("\n");
        }

        System.out.println(sb);
    }

    private static String arrToString(int[] arr, int head, int tail, boolean isReverse) {
        StringBuilder sb = new StringBuilder();

        sb.append("[");

        if (!isReverse) {
            for (int i = head; i < tail; i++) {
                sb.append(arr[i]);

                if (i < tail - 1) {
                    sb.append(",");
                }
            }
        } else {
            for (int i = tail - 1; i >= head; i--) {
                sb.append(arr[i]);

                if (i > head) {
                    sb.append(",");
                }
            }
        }

        return sb.append("]").toString();
    }

}