package kakao.sheepwolf2022;

import java.util.Arrays;

public class Solution3 {
    //유튜브 공개강좌에 나온 풀이
    // https://www.youtube.com/watch?v=caGtdr3_nxs
    //슬래시 3개짜리 주석은 해당 강좌의 주석

    /// 왼쪽 자식, 오른쪽 자식, 양/늑대 값
    int[] l = new int[20];
    int[] r = new int[20];
    int[] value = new int[20];
    int infoLength;
    int answer = 1;
    int[] visit = new int[1 << 17]; ///visit[x] : 상태 x의 방문여부
    // * 비트마스킹 (메모이제이션의 일종)
    // 주어진 노드갯수 조건이 17개 이므로 17bits의 방문표시를 할수 있어야 하며 (1<<17)
    // 따라서 방문표시를 할수 있는 경우의수는 2^17가지 이다
    // -> 이걸 모두 방문해본 flood fill (bfs든 dfs든)
    // visit[1] : 방문상태가 0b00000000000000001 (0번노드만 방문해봄) 일때 연산을 해보았느냐는 얘기

    /// 상태에 대한 dfs 함수
    void solve(int state) {
        if (visit[state] == 1) {
            return;
        }
        visit[state] = 1;

        /// wolf : 늑대의 수, num : 전체 정점의 수
        int wolf = 0;
        int num = 0;
        for (int i = 0; i < infoLength; i++) {
            // 지금 내 state가 가본 node의 갯수가 num이 될것임
            // 그 node들의 wolf 갯수가 계속 합산될것임
            if ((state & (1 << i)) != 0) {
                num++;
                wolf += value[i];
            }
        }

        /// 만약 늑대가 절반 이상일 경우 방문할 수 없는 상태이니 종료
        // 만약 늑대가 절반 이상일 경우, 다음 상태에 방문할 수 없는 상태이니 종료
        if ((2 * wolf) >= num) {
            return;
        }
        /// 현재 state의 양의 수가 answer보다 클 경우 answer를 갱신
        answer = Math.max(answer, num - wolf);

        /// 이제 다음 상태로 넘어갈 시간
        for (int i = 0; i < infoLength; i++) {
            /// i번째 비트가 꺼져있는 경우, 해당 정점이 없으니 넘어감
            if ((state & (1 << i)) == 0) {
                continue;
            }

            /// 현재 보고 있는 i번째 정점의 left가 있다면
            if (l[i] != -1) {
                // OR연산으로 새 하위 state를 만들어 재귀
                solve(state | (1 << l[i]));
            }

            /// 현재 보고 있는 i번째 정점의 right가 있다면
            if (r[i] != -1) {
                solve(state | (1 << r[i]));
            }
        }
    }

    public int solution(int[] info, int[][] edges) {
        infoLength = info.length;
        Arrays.fill(l, -1);
        Arrays.fill(r, -1);

        // info를 전역변수 value로 옮김
        for (int i = 0; i < infoLength; i++) {
            value[i] = info[i];
        }

        // edges를 l[] r[]에 정리
        for (int i = 0; i < infoLength - 1; i++) {
            int parent = edges[i][0]; /// 부모
            int child = edges[i][1]; /// 자식

            if (l[parent] == -1) {
                l[parent] = child;
            } else {
                r[parent] = child;
            }
        }

        solve(1); /// 0번 노드만 포함된 상태에서 dfs 시작
        return answer;
    }
}
