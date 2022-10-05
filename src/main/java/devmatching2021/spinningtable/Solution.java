package devmatching2021.spinningtable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    int[][] base;
    List<Integer> elements;

    public int[] solution(int rows, int columns, int[][] queries) {

        int[] answer = new int[queries.length];
        int idx = 0;
        base = new int[rows][columns];

        for (int[] query : queries) {
            answer[idx] = afterSpin(query);
            idx++;
        }

        return answer;
    }

    private int afterSpin(int[] query) {
        int[][] tmp = base.clone();
        elements = new ArrayList<>();

        for (int i = 0; i < base.length; i++) {
            if ((i + 1) == query[0]) {
                tmp[i] = rotateRight(i, query[1] - 1, query[3] - 1);
            }

            if ((i + 1) > query[0]
                    && (i + 1) < query[2]) {
                tmp[i] = rotateColumns(i, query[1] - 1, query[3] - 1);
            }

            if ((i + 1) == query[2]) {
                tmp[i] = rotateLeft(i, query[1] - 1, query[3] - 1);
            }
        }
        base = tmp.clone();

        return Collections.min(elements);
    }

    private int[] rotateColumns(int line, int start, int end) {
        int[] tmp = base[line].clone();

        for (int i = 0; i < tmp.length; i++) {
            if (i == start) {
                tmp[i] = base[line + 1][i];
                elements.add(tmp[i]);
            }
            if (i == end) {
                tmp[i] = base[line - 1][i];
                elements.add(tmp[i]);
            }
        }

        return tmp;
    }

    private int[] rotateLeft(int line, int start, int end) {
        int[] tmp = base[line].clone();

        for (int i = 0; i < tmp.length; i++) {
            if (i == end) {
                tmp[i] = base[line - 1][i];
                elements.add(tmp[i]);
            }
            if (i >= start
                    && i < end) {
                tmp[i] = base[line][i + 1];
                elements.add(tmp[i]);
            }
        }

        return tmp;
    }

    private int[] rotateRight(int line, int start, int end) {
        int[] tmp = base[line].clone();

        for (int i = 0; i < tmp.length; i++) {
            if (i == start) {
                tmp[i] = base[line + 1][i];
                elements.add(tmp[i]);
            }
            if (i > start
                    && i <= end) {
                tmp[i] = base[line][i - 1];
                elements.add(tmp[i]);
            }
        }

        return tmp;
    }
}