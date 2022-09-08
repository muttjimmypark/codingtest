package sheepwolf2022;

// 2022 블라인드 - 양과 늑대
// 220905 23:05 - 23:15
// 23:30 - 24:13
// 220906 13:30 - 14:00
// 14:50 - 16:10
// 16:20 - 17:15
// 17:15 - 18:08 저번 코테 절차 등 검색해서 읽음
// 26:00 - 26:50
// 220907 15:10 - 16:30
// 19:00 - 20:00

import java.util.Arrays;

class Solution {

    int[] ginfo = new int[20];
    int infoLength;
    int[] l = new int[20];
    int[] r = new int[20];
    boolean[] visit = new boolean[1 << 17];
    int answer = 0;

    public int solution(int[] info, int[][] edges) {
        infoLength = info.length;
        for (int i = 0; i < infoLength; i++) {
            ginfo[i] = info[i];
        }

        Arrays.fill(l, -1);
        Arrays.fill(r, -1);
        for (int i = 0; i < infoLength - 1; i++) {
            int parent = edges[i][0];
            int child = edges[i][1];

            if (l[parent] == -1) {
                l[parent] = child;
                continue;
            }
            r[parent] = child;
        }

        Arrays.fill(visit, false);
        solve(1);
        return answer;
    }

    private void solve(int state) {
        if (visit[state]) {
            return;
        }
        visit[state] = true;

        // 주어진 state의 노드 갯수와 늑대 갯수를 파악
        int nodeCountInThisState = 0;
        int wolf = 0;
        for (int i = 0; i < infoLength; i++) {
            if ((state & (1 << i)) != 0) {
                nodeCountInThisState++;
                wolf += ginfo[i];
            }
        }

        // 늑대 갯수가 과반이 안되면 answer에 투입시도
        if ((wolf * 2) >= nodeCountInThisState) {
            return;
        }
        answer = Math.max(answer, nodeCountInThisState - wolf);

        //재귀 dfs 진행
        for (int i = 0; i < infoLength; i++) {
            if ((state & (1 << i)) == 0) {
                continue;
            }

            if (l[i] != -1) {
                solve(state | (1 << l[i]));
            }

            if (r[i] != -1) {
                solve(state | (1 << r[i]));
            }
        }
    }
}
