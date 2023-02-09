package bdalgoclass.exercises.x07.boj1021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        Integer.parseInt(st.nextToken()); // m

        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }

        st = new StringTokenizer(br.readLine());
        int result = 0;
        int remain = n;
        while (st.hasMoreTokens()) {
            int targetIdx = deque.indexOf(Integer.parseInt(st.nextToken()));
            int midIdx = remain / 2;
            if (remain % 2 == 0) {
                midIdx--;
            }
            int move = 0;

            if (targetIdx <= midIdx) {
                for (int i = 0; i < targetIdx; i++) {
                    deque.addLast(deque.removeFirst());
                    move++;
                }

            } else {
                for (int i = remain; i > targetIdx; i--) {
                    deque.addFirst(deque.removeLast());
                    move++;
                }
            }

            deque.removeFirst();
            remain--;
            result += move;
        }

        System.out.println(result);
    }
}