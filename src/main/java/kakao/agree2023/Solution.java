package kakao.agree2023;

import java.util.*;

class Solution {

    Map<String, Integer> gTerms;

    public int[] solution(String today, String[] terms, String[] privacies) {

        List<Integer> ans = new ArrayList<>();

        gTerms = new HashMap<>();
        for (String term : terms) {
            String[] tmp = term.split(" ");
            gTerms.put(tmp[0], Integer.parseInt(tmp[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] tmp = privacies[i].split(" ");

            if (dateCompare(tmp[0], today, gTerms.get(tmp[1]))) {
                ans.add(i + 1);
            }
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }

    private boolean dateCompare(String signDate, String today, int limitMonth) {
        int[] signSplit = Arrays.stream(signDate.split("\\.")).mapToInt(Integer::parseInt).toArray();
        int[] todaySplit = Arrays.stream(today.split("\\.")).mapToInt(Integer::parseInt).toArray();

        while (signSplit[0] < todaySplit[0]) {
            todaySplit[1] += 12;
            todaySplit[0]--;
        }

        if (signSplit[1] + limitMonth < todaySplit[1]) {
            return true;
        }

        return (signSplit[1] + limitMonth == todaySplit[1])
                & (signSplit[2] <= todaySplit[2]);
    }
}