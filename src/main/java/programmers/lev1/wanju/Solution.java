package programmers.lev1.wanju;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {

        Map<String, Integer> ptcp = new HashMap<>();

        for (String name : participant) {
            if (ptcp.containsKey(name)) {
                ptcp.put(name, ptcp.get(name) + 1);
                continue;
            }

            ptcp.put(name, 1);
        }

        for (String name : completion) {
            ptcp.put(name, ptcp.get(name) - 1);
        }

        return ptcp.keySet().stream().filter(e -> ptcp.get(e) == 1).findFirst().orElse("error");
    }
}