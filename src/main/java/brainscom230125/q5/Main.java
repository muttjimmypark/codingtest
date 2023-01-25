package brainscom230125.q5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /**
     * javascript 경험이 없어 Java로 작성했습니다
     */

    public static void main(String[] args) throws IOException {
        Map<String, Integer> words = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        while (st.hasMoreTokens()) {
            String tmp = st.nextToken();

            if (words.containsKey(tmp)) {
                int value = words.get(tmp) + 1;
                words.put(tmp, value);
                continue;
            }

            words.put(tmp, 1);
        }

        StringBuilder sb = new StringBuilder();
        for (String key : words.keySet()) {
            sb.append(key).append(":").append(words.get(key)).append("\n");
        }
        System.out.println(sb);

    }
}