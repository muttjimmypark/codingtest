package programmers.lev3.dualpriorityqueue;

import java.util.LinkedList;

class Solution {
    LinkedList<Integer> min;
    LinkedList<Integer> max;

    public int[] solution(String[] operations) {

        min = new LinkedList<>();
        max = new LinkedList<>();

        for (String operation : operations) {
            String[] now = operation.split(" ");

            if (now[0].equals("I")) {
                insertNum(Integer.parseInt(now[1]));
                continue;
            }

            if (now[1].equals("-1")) {
                minDel();
                continue;
            }

            maxDel();
        }

        return findMinMax();
    }

    private int[] findMinMax() {
        int minSize = min.size();
        int maxSize = max.size();

        if (minSize + maxSize == 0) {
            return new int[]{0, 0};
        }

        if (minSize + maxSize == 1) {
            if (minSize > maxSize) {
                return new int[]{min.removeFirst(), min.removeFirst()};
            }

            return new int[]{max.removeFirst(), max.removeFirst()};
        }

        return new int[]{
                maxSize == 0 ? min.removeLast() : max.removeLast(),
                minSize == 0 ? max.removeFirst() : min.removeFirst()};
    }

    private void maxDel() {
        if (max.size() != 0) {
            max.removeLast();
            return;
        }

        if (min.size() != 0) {
            min.removeLast();
        }
    }

    private void minDel() {
        if (min.size() != 0) {
            min.removeFirst();
            return;
        }

        if (max.size() != 0) {
            max.removeFirst();
        }
    }

    private void insertNum(int input) {
        while (min.size() > 0 && min.peekLast() > input) {
            max.addFirst(min.removeLast());
        }

        while (max.size() > 0 && max.peekFirst() < input) {
            min.addLast(max.removeFirst());
        }

        min.addLast(input);
    }
}