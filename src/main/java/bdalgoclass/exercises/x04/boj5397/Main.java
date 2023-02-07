package bdalgoclass.exercises.x04.boj5397;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int caseNumber = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < caseNumber; i++) {
            sb.append(keylogger(br.readLine().toCharArray())).append("\n");
        }

        System.out.println(sb);
    }

    private static String keylogger(char[] charArr) {
        LinkedList<Character> ll = new LinkedList<>();

        int idx = 0;
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == '<') {
                idx = Math.max(0, idx - 1);
                continue;
            }

            if (charArr[i] == '>') {
                if (ll.size() > 0) {
                    idx = Math.min(ll.size(), idx + 1);
                }
                continue;
            }

            if (charArr[i] == '-') {
                if (idx > 0) {
                    idx--;
                    ll.remove(idx);
                }
                continue;
            }

            ll.add(idx, charArr[i]);
            idx++;
        }

        StringBuilder result = new StringBuilder();
        while (!ll.isEmpty()) {
            result.append(ll.removeFirst());
        }
        return result.toString();
    }
}