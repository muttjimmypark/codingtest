package springintern230211.q1;
//
//import java.math.BigDecimal;
//
//class Solution {
//    public int solution(int[][] lotteries) {
//        int idx = 0;
//
//        BigDecimal per = new BigDecimal(0);
//        int mx = 0;
//        for (int i = 0; i < lotteries.length; i++) {
//
//            BigDecimal childNum = new BigDecimal(lotteries[i][0]);
//            BigDecimal momNum = new BigDecimal(lotteries[i][1] + 1);
//            BigDecimal now = childNum.divide(momNum);
//
//            int comp = per.compareTo(now);
//
//            if (comp > 0) {
//                continue;
//            }
//
//            if (comp == 0
//                    && mx < lotteries[i][2]) {
//
//                mx = lotteries[i][2];
//                idx = i + 1;
//
//                continue;
//            }
//
//            if (comp < 0) {
//
//                per = now;
//                mx = lotteries[i][2];
//                idx = i + 1;
//            }
//
//        }
//
//        return idx;
//    }
//}

class Solution {
    public int solution(int[][] lotteries) {
        int idx = 0;

        long per = 0;
        int mx = 0;
        for (int i = 0; i < lotteries.length; i++) {

            long now;
            if (lotteries[i][0] == (lotteries[i][1] + 1)) {
                now = 1000000000L;
            } else {
                now = (lotteries[i][0] * 10000000L) / (lotteries[i][1] + 1);
            }

            if (per > now) {
                continue;
            }

            if (per == now
                    && mx < lotteries[i][2]) {

                mx = lotteries[i][2];
                idx = i + 1;

                continue;
            }

            if (per < now) {

                per = now;
                mx = lotteries[i][2];
                idx = i + 1;
            }

        }

        return idx;
    }
}

// 4,6,7