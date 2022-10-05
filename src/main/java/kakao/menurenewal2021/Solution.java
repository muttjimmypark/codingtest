package kakao.menurenewal2021;

// 1500 - 1606
// 1630 - 1636

import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {

        List<HashMap<String, Integer>> frequency = new ArrayList<HashMap<String, Integer>>();
        for (int i = 0; i < 11; i++) {
            Map<String, Integer> tmp = new HashMap<String, Integer>();
//            frequency.add(tmp);
        }

        /// A. 코스 메뉴 조합 추출
        for (int t = 0; t < orders.length; t++) {
            char order[] = orders[t].toCharArray();
            Arrays.sort(order);
            for (int i = 0; i < (1 << order.length); i++) {
                String menu = "";
                int tmp = i;
                for (int j = 0; j < order.length; j++) {
                    if (tmp % 2 == 1) {
                        menu += order[j];
                    }
                    tmp /= 2;
                }

                int count = frequency.get(menu.length()).getOrDefault(menu, 0);
                frequency.get(menu.length()).put(menu, count + 1);
            }
        }

        /// B. 코스요리 메뉴 계산
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < course.length; i++) {
            int maxFrequency = 0;

            for (Map.Entry mapElem : frequency.get(course[i]).entrySet()) {
                maxFrequency = Math.max(maxFrequency, (int) mapElem.getValue());
            }

            if (maxFrequency < 2) {
                continue;
            }

            for (Map.Entry mapElem : frequency.get(course[i]).entrySet()) {
                if ((int) mapElem.getValue() == maxFrequency) {
                    answer.add((String) mapElem.getKey());
                }
            }
        }

        Collections.sort(answer);
        return answer.toArray(new String[answer.size()]);
    }
}
