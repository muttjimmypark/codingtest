package kakao.equalizetwoques2022intern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution2 {

    public int solution(int[] queue1, int[] queue2) {

        long q1sum = Arrays.stream(queue1).sum();
        long q2sum = Arrays.stream(queue2).sum();
        if (q1sum == q2sum) {
            return 0;
        }
        if ((q1sum + q2sum) < Math.max(Arrays.stream(queue1).max().getAsInt(), Arrays.stream(queue2).max().getAsInt())) {
            return -1;
        }
        if ((q1sum + q2sum) % 2 != 0) {
            return -1;
        }

        int queLength = queue1.length;
//        if (queLength != queue2.length) {
//            throw new Exception();
//        }
        List<Integer> uniteQue = new ArrayList<>();
        if (q1sum < q2sum) {
            for (int i = 0; i < queLength; i++) {
                uniteQue.add(queue1[i]);
            }
            for (int i = 0; i < queLength; i++) {
                uniteQue.add(queue2[i]);
            }
        }
        if (q2sum < q1sum) {
            for (int i = 0; i < queLength; i++) {
                uniteQue.add(queue2[i]);
            }
            for (int i = 0; i < queLength; i++) {
                uniteQue.add(queue1[i]);
            }
        }

        long goal = (q1sum + q2sum) / 2;
        for (int subStart = 0; subStart < queLength * 2; subStart++) {
            for (int subEnd = subStart; subEnd < queLength * 2; subEnd++) {
                long subSum = uniteQue.subList(subStart, subEnd).stream().mapToLong(Long::valueOf).sum();
                if (goal < subSum) {
                    break;
                }
                if (goal == subSum) {
                    return subStart + subEnd - queLength;
                }
            }
        }

        System.out.println("not found");
        return -1;
    }
}