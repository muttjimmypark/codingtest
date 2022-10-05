package programmers.lev1.uniform;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        List<Integer> lLost = Arrays.stream(lost).boxed().collect(Collectors.toList());
        List<Integer> lReserve = Arrays.stream(reserve).boxed().collect(Collectors.toList());
        int[] sample = new int[n];

        for (int i = 1; i <= n; i++) {
            if (lLost.contains(i) && lReserve.contains(i)) {
                sample[i - 1] = 1;
                continue;
            }

            if (lLost.contains(i)) {
                sample[i - 1] = 0;
                continue;
            }

            if (lReserve.contains(i)) {
                sample[i - 1] = 2;
                continue;
            }

            sample[i - 1] = 1;
        }

        for (int i = 0; i < n; i++) {
            if (sample[i] != 0) {
                continue;
            }

            if ((i - 1) >= 0
                    && sample[i - 1] == 2) {
                sample[i - 1] = 1;
                sample[i] = 1;
                continue;
            }

            if ((i + 1) < n
                    && sample[i + 1] == 2) {
                sample[i + 1] = 1;
                sample[i] = 1;
            }
        }

        for (int s : sample) {
            if (s != 0) {
                answer++;
            }
        }

        return answer;
    }
}