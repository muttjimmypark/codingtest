package equalizetwoques2022intern;

// 2022 블라인드인턴 - 두 큐 합 같게 만들기
// 220907 20:10 - 21:58
// 220908 15:55 - 17:55 1번풀이 시간통과 실패
// 220910 21:35 - 22:32
// 23:00 - 23:34 2번풀이 시간통과 실패 (11~28, 30)
// 23:34 - 24:07 최종풀이 시간초과 (24만)
// 24:20 -

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int[] queue1, int[] queue2) {

        int queLength = queue1.length;
        long q1sum = 0L;
        long q2sum = 0L;
        List<Integer> q1 = new ArrayList<>();
        List<Integer> q2 = new ArrayList<>();
        for (int i = 0; i < queLength; i++) {
            int tmp = queue1[i];
            q1sum += tmp;
            q1.add(tmp);

            tmp = queue2[i];
            q2sum += tmp;
            q2.add(tmp);
        }

        for (int i = 0; i < 600000; i++) {
            if (q1sum > q2sum) {
                int tmp = q1.remove(0);
                q2.add(tmp);
                q1sum -= tmp;
                q2sum += tmp;
                continue;
            }
            if (q1sum < q2sum) {
                int tmp = q2.remove(0);
                q1.add(tmp);
                q1sum += tmp;
                q2sum -= tmp;
                continue;
            }

            return i;
        }

        return -1;
    }
}
