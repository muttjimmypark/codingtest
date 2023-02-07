package programmers.lev3.gps;

import java.util.Arrays;

class Solution {

    boolean[][] routes;
    int gk;

    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        int answer = 20;

        gk = k;
        routes = new boolean[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(routes[i], false);
            routes[i][i] = true;
        }

        for (int[] edge : edge_list) {
            routes[edge[0]][edge[1]] = true;
            routes[edge[1]][edge[0]] = true;
        }


        for (int i = 0; i < k; i++) {

        }


        return answer;
    }

}