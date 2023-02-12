package programmers.lev2.spinningtable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {

    int[][] arr;
    int mx;

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        Arrays.fill(answer, 0);

        arr = new int[rows][columns];
        int tmp = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = tmp++;
            }
        }
        mx = rows * columns;

        for (int i = 0; i < queries.length; i++) {
            answer[i] = spin(queries[i]);
        }

        return answer;
    }

    private int spin(int[] query) {

        int[] now = query.clone();
        for (int i = 0; i < 4; i++) {
            now[i]--;
        }

        int min = mx;
        int tmp = 0;

        for (int i = now[0]; i <= now[2]; i++) {

            if (i == now[0]) {
                tmp = arr[i][now[3]];
                min = Math.min(tmp, min);

//                for (int j = now[1] + 1; j <= now[3]; j++) {
                for (int j = now[3]; j >= now[1] + 1; j--) {
                    arr[i][j] = arr[i][j - 1];
                    min = Math.min(arr[i][j], min);
                }

                arr[i][now[1]] = arr[i + 1][now[1]];
                min = Math.min(arr[i][now[1]], min);

                continue;
            }

            if (i == now[2]) {
                for (int j = now[1]; j < now[3]; j++) {
                    arr[i][j] = arr[i][j + 1];
                    min = Math.min(arr[i][j], min);
                }

                arr[i][now[3]] = tmp;
                min = Math.min(arr[i][now[3]], min);

                continue;
            }

            /**
             * mid
             */
            arr[i][now[1]] = arr[i + 1][now[3]];
            min = Math.min(arr[i][now[1]], min);

            int tmp2 = arr[i][now[3]];
            min = Math.min(tmp2, min);
            arr[i][now[3]] = tmp;
            min = Math.min(arr[i][now[3]], min);
            tmp = tmp2;

        }

        return min;
    }


}



//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int r = Integer.parseInt(br.readLine());
//        int c = Integer.parseInt(br.readLine());
//
//        int qLen = Integer.parseInt(br.readLine());
//        int[][] q = new int[qLen][4];
//        for (int i = 0; i < qLen; i++) {
//            q[i] = Arrays.stream(br.readLine().split(","))
//                    .mapToInt(Integer::parseInt)
//                    .toArray();
//        }
//
//        int[] want = solution(r, c, q);
//        for (int i = 0; i < want.length; i++) {
//            System.out.println(want[i]);
//        }
//    }