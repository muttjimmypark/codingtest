package infoboss230227.q3;

import java.util.*;

class Solution {
    public String[] solution(String[] orders) {

        Map<String, HashSet<String>> tmp = new HashMap<>();

        for (String order : orders) {
            String[] now = order.split(" ");

            if (!tmp.containsKey(now[0])) {
                tmp.put(now[0], new HashSet<>());
            }

            HashSet<String> menus = tmp.get(now[0]);
            menus.addAll(Arrays.asList(now).subList(1, now.length));

            tmp.put(now[0], menus);
        }

        int mx = tmp.values().stream()
                .mapToInt(HashSet::size)
                .max().orElse(0);

        return tmp.keySet().stream()
                .filter(e -> tmp.get(e).size() == mx)
                .sorted()
                .toArray(String[]::new);
    }
}