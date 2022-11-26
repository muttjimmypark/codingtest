package kakao.archer2022;

import java.util.Arrays;

class Solution {

    /// a가 b보다 더 좋은 배치일 경우 true
    // 좋은배치라는건 같은점수에서 더낮은표적을 맞추는경우
    public boolean cmp(int[] a, int[] b) {
        for (int i = 11; i >= 0; i++) {
            if (a[i] != b[i]) {
                return a[i] > b[i];
            }
        }

        return false;
    }

    /// 라이언이 가장 큰 점수 차이로 우승할 수 있는 결과를 저장
    /// mn[0..10] : 10-i점에서 라이언이 맞힌 화살의 수
    /// mn[11] : 점수 차이
    int[] mn = new int[12];

    /// 백트래킹으로 모든 경우를 따져볼 변수, 저장형식은 mn과 동일
    int[] arrow = new int[12];

    /// idx번째 값을 정함, 현재 화살은 left개 남아있음
    public void bt(int idx, int left, int[] info) {
        /// 10번째 값이 정해진 상황이라면 라이언의 점수를 계산
        if (idx == 10) {
            arrow[idx] = left;
            int score = 0;
            for (int i = 0; i <= 10; i++) {
                if (arrow[i] > info[i]) {
                    score += (10 - i);
                } else if (info[i] != 0) {
                    score -= (10 - i);
                }
            }

            // 졌으면 점수 기록을 포기, 이겼으면 기록
            if (score <= 0) {
                return;
            }
            arrow[11] = score;

            /// 지금 결과가 기존의 결과보다 좋다면 ret를 갱신
            if (cmp(arrow, mn)) {
                for (int i = 0; i < 12; i++) {
                    mn[i] = arrow[i];
                }
            }

            return;
        }

        // 지금idx표적에 0개~남은전부 맞추는 경우의수 다 대입
        for (int i = 0; i <= left; i++) {
            arrow[idx] = i; /// idx번째 화살의 수를 i개로 정함
            bt(idx + 1, left - i, info); /// 다음단계로 들어감
        }
    }

    public int[] solution(int n, int[] info) {
        Arrays.fill(mn, -1);
        bt(0, n, info); /// 백트래킹을 통해 ret에 정답을 넣어둠

        if (mn[0] == -1) {
            return new int[]{-1};
        }

        // 점수차를 위해 기록하는공간까지 가지던 mn에서
        // ret에 필요한 만큼만 추출하여 return
        int[] ret = new int[11];
        for (int i = 0; i < 11; i++) {
            ret[i] = mn[i];
        }
        return ret;
    }
}