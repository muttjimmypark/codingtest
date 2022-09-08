package equalizetwoques2022intern;

// 2022 블라인드인턴 - 두 큐 합 같게 만들기
// 220907 20:10 - 21:58
// 220908 15:55 -

import java.util.ArrayList;
import java.util.List;

class Solution1 {
    // [1,1,1,8,10,9] [1,1,1,1,1,1]
    // 이런 극단적인 경우로 여러번 넣뺐해서
    // 중간원소 한두개만 두고 나머지를 반대쪽에 몰아야 하는 경우가 있으므로
    // 설계 자체가 틀렸다

    //    int answer = -2;
    int queSize = 0;
    long allSum = 0L;
    List<Integer> gq1;
    List<Integer> gq2;

    public int solution(int[] queue1, int[] queue2) {
//        if (queue1.length != queue2.length) {
//            throw new Exception();
//        }
        gq1 = new ArrayList<>();
        gq2 = new ArrayList<>();

        queSize = queue1.length;
        for (int i = 0; i < queSize; i++) {
            gq1.add(queue1[i]);
            gq2.add(queue2[i]);
            allSum += queue1[i];
            allSum += queue2[i];
        }

        // 한 원소의 값이 나머지 원소들의 총합보다 크면 중단
//        if (!validationElements()) {
//            return -1;
//        }

        // 원소의 총 합이 반으로 나눠떨어지지 않으면 중단
        if ((allSum % 2) != 0) {
            return -1;
        }

        // 중단조건 검토 끝났으니 큐섞기 시작
        // 최대로 나올 수 있는 이동 횟수 : (queSize * 2) <--아니다
        for (int moveCase = 0; moveCase < (queSize * 2); moveCase++) {
            for (int bDeque = 0; bDeque <= moveCase; bDeque++) {
                int aDeque = moveCase - bDeque;

                // 실현가능한 횟수인지 검증
                if ((queSize - aDeque + bDeque < 1)
                        | (queSize - bDeque + aDeque < 1)) {
                    continue;
                }

                // 실제 섞어보기
                if (mixAndCalculate(aDeque, bDeque)) {
                    return moveCase;
                }
            }
        }

        return -1;
    }

//    private boolean validationElements() {
//        for (int i = 0; i < queSize; i++) {
//            if (gq1[i] > (allSum / 2)) {
//                return false;
//            }
//            if (gq2[i] > (allSum / 2)) {
//                return false;
//            }
//        }
//        return true;
//    }

    private boolean mixAndCalculate(int aDeque, int bDeque) {
        List<Integer> resultA = new ArrayList<>();
        for (int i = 0; i < queSize; i++) {
            resultA.add(gq1.get(i));
        }

        if (aDeque >= queSize) {
            for (int i = 0; i < bDeque; i++) {
                resultA.add(gq2.get(i));
            }
            for (int i = 0; i < aDeque; i++) {
                resultA.remove(0);
            }
        } else {
            for (int i = 0; i < aDeque; i++) {
                resultA.remove(0);
            }
            for (int i = 0; i < bDeque; i++) {
                resultA.add(gq2.get(i));
            }
        }

        return resultA.stream().mapToLong(Long::valueOf).sum() == (allSum / 2);
    }
}