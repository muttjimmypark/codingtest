package bdalgoclass.exercises.x07.boj1021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }

        st = new StringTokenizer(br.readLine());
        int result = 0;
        int nowMove = 0;
        while (st.hasMoreTokens()) {
            int order = Integer.parseInt(st.nextToken());

            while (true) {
                if (deque.peekFirst() == order) {
                    deque.removeFirst();
                    result += nowMove;
                    nowMove = 0;
                    break;
                }

                //앞으로가기 뒤로가기 비교해서 짧은쪽


            }


        }
    }
}
