package programmers.lev2.spywear;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {

        Map<String, Integer> typeCount = new HashMap<>();
        for (String[] wear : clothes) {
            if (typeCount.containsKey(wear[1])) {
                typeCount.put(wear[1], typeCount.get(wear[1]) + 1);
                continue;
            }

            typeCount.put(wear[1], 1);
        }

        int answer = 1;
        for (Integer value : typeCount.values()) {
            answer *= (value + 1);
        }
        return answer - 1;
    }
}