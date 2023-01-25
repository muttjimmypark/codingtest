package brainscom230125.q8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("insert S : ");
        String s = br.readLine();
        System.out.print("insert W : ");
        String w = br.readLine();

        System.out.println(solution(s, w));

    }

    private static int solution(String s, String w) {
        List<String> sElem = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(s);
        while (st.hasMoreTokens()) {
            sElem.add(st.nextToken());
        }

        for (int i = 0; i < sElem.size(); i++) {
            if (sElem.get(i).equals(w)) {
                return i + 1;
            }
        }
        return 0;
    }
}