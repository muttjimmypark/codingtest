package programmers.lev2.phonenumberlist;

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {

        String[] sorted = phone_book.clone();
        Arrays.sort(sorted);

        for (int i = 1; i < sorted.length; i++) {
            if (sorted[i].startsWith(sorted[i - 1])) {
                return false;
            }
        }

        return true;
    }
}

//class Solution {
//    public boolean solution(String[] phone_book) {
//
//        Map<Integer, List<String>> setted = new HashMap<>();
//        for (String num : phone_book) {
//            int len = num.length();
//
//            List<String> tmp;
//
//            if (setted.containsKey(len)) {
//                tmp = setted.get(len);
//            } else {
//                tmp = new ArrayList<>();
//            }
//
//            tmp.add(num);
//            setted.put(len, tmp);
//        }
//
//        for (int i = 1; i < 20; i++) {
//            if (!setted.containsKey(i)) {
//                continue;
//            }
//
//            List<String> tmp = setted.get(i);
//            for (String small : tmp) {
//                for (int j = i + 1; j <= 20; j++) {
//                    if (!setted.containsKey(j)) {
//                        continue;
//                    }
//
//                    if (setted.get(j).stream()
//                            .anyMatch(e -> e.startsWith(small))) {
//                        return false;
//                    }
//                }
//            }
//        }
//
//        return true;
//    }
//}

// class Solution {
//     public boolean solution(String[] phone_book) {

//         for (int i = 0; i < phone_book.length; i++) {
//             for (int j = 0; j < phone_book.length; j++) {
//                 if (i == j) {
//                     continue;
//                 }

//                 if (phone_book[i].length() > phone_book[j].length()) {
//                     continue;
//                 }

//                 if (phone_book[j].startsWith(phone_book[i])) {
//                     return false;
//                 }
//             }
//         }

//         return true;
//     }
// }