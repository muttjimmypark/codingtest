package crane2019;

// 2019 겨울 인턴십 - 크레인 인형뽑기 게임
// 04:05 - 05:36 (90)

import java.util.*;

class Solution {
    List<Queue<Integer>> gBoard;
    List<Integer> dolls;

    public int solution(int[][] board, int[] moves) {

        gBoard = new ArrayList<>();
        int size = board.length;
        for (int i = 0; i < size; i++) {
            Queue<Integer> tmp = new LinkedList<>();

            for (int j = 0; j < size; j++) {
                if (board[j][i] != 0) {
                    tmp.add(board[j][i]);
                }
            }

            gBoard.add(tmp);
        }

        size = moves.length;
        dolls = new ArrayList<>();
        int answer = 0;
        int dollSize = 0;

        for (int i = 0; i < size; i++) {
            Queue<Integer> tmp = gBoard.remove(moves[i] - 1);
            Integer poll = tmp.poll();
            gBoard.add(moves[i] - 1, tmp);

            if (dollSize == 0) {
                if (poll != null) {
                    dolls.add(poll);
                    dollSize++;
                    continue;
                }
            }

            if (poll == null) {
                continue;
            }

            if (dolls.get(dollSize - 1) == (int) poll) {
                dolls.remove(dollSize - 1);
                answer += 2;
                dollSize--;
                continue;
            }

            dolls.add(poll);
            dollSize++;
        }

        return answer;
    }
}