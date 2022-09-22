package baduser2019;

import java.util.ArrayList;
import java.util.List;

class Solution1 {

    public int solution(String[] user_id, String[] banned_id) {
//        Map<Integer, List<Integer>> banListCases = new HashMap<>();
//        List<Integer> matchEveryIndexes = new ArrayList<>();
        List<Integer> banListCases = new ArrayList<>();
        int matchEveryIndexes = 0;

        for (String s : banned_id) {
            int tmp = 0;

            for (int i = 0; i < user_id.length; i++) {
                if (matchWords(user_id[i], s)) {
                    tmp = (tmp | (1 << i));
                    matchEveryIndexes = matchEveryIndexes | (1 << i);
                }
            }

            banListCases.add(tmp);
        }

        return solve(banListCases, matchEveryIndexes);
    }

    private int solve(List<Integer> banListCases, int matchEveryIndexes) {
        
        return 0;
    }

//    private int solve(Map<Integer, List<Integer>> banListCases, List<Integer> matchEveryIndexes) {
//        for (int i = 0; i < banListCases.size(); i++) {
//            List<Integer> tmp = banListCases.get(i);
//
//            if (tmp.size() == 1) {
//                Map<Integer, List<Integer>> tmp1 = new HashMap<>(banListCases);
//                List<Integer> tmp2 = new ArrayList<>(matchEveryIndexes);
//                tmp1.remove(i);
//                tmp2.remove(tmp.get(0));
//
//                return solve(tmp1, tmp2);
//            }
//
//            if (tmp.size() == banListCases.values().stream().filter(list -> list.equals(tmp)).count()) {
//                Map<Integer, List<Integer>> tmp1 = new HashMap<>(banListCases);
//                List<Integer> tmp2 = new ArrayList<>(matchEveryIndexes);
//
//            }
//        }
//        return 0;
//    }
}