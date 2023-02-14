package bdalgoclass.exercises.x0F.boj11652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Long, Integer> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            long tmp = Long.parseLong(br.readLine());
            int count = 0;
            if (map.containsKey(tmp)) {
                count = map.get(tmp);
            }
            map.put(tmp, ++count);
        }

        int mx = Collections.max(map.values());

        System.out.println(map.entrySet().stream()
                .filter(e -> e.getValue().equals(mx))
                .map(Map.Entry::getKey)
                .sorted()
                .findFirst().get());
    }
}