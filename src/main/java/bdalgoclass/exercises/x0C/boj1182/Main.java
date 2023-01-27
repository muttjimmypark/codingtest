package bdalgoclass.exercises.x0C.boj1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int s;
    static int[] arr;
    static int count;
    static int addElem;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        st.nextToken(); // int n = arr.length
        s = Integer.parseInt(st.nextToken());
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        count = 0;
        addElem = 0;

        solution(0);
        if (s == 0) {
            count--;
        }
        System.out.println(count);
    }

    private static void solution(int idx) {
        if (idx == arr.length) {
            if (addElem == s) {
                count++;
            }
            return;
        }

        int[] nowCases = {0, arr[idx]};
        for (int i = 0; i < 2; i++) {
            addElem += nowCases[i];
            solution(idx + 1);
            addElem -= nowCases[i];
        }
    }
}