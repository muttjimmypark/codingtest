package hiringtest230120.linegame;

import java.util.*;

import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'findPoint' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts 2D_INTEGER_ARRAY lines as parameter.
     */

    public static List<Integer> findPoint(List<List<Integer>> lines) {
        // Write your code here

        int xLimit = 0;
        int yLimit = 0;
        for (List<Integer> line : lines) {
            xLimit = Math.max(xLimit, line.get(0));
            xLimit = Math.max(xLimit, line.get(2));
            yLimit = Math.max(yLimit, line.get(1));
            yLimit = Math.max(yLimit, line.get(3));
        }

        int minimumDistance = Integer.MAX_VALUE;
        int xResult = 0;
        int yResult = 0;

        for (int i = 0; i < xLimit; i++) {
            for (int j = 0; j < yLimit; j++) {
                int finalI = i;
                int finalJ = j;
                int tmp = lines.stream().mapToInt(l -> calDistance(finalI, finalJ, l)).sum();
                if (tmp < minimumDistance) {
                    minimumDistance = tmp;
                    xResult = i;
                    yResult = j;
                }
            }
        }

        return Arrays.asList(xResult, yResult);
    }

    private static int calDistance(int x, int y, List<Integer> line) {

        int xFirst = line.get(0);
        int yFirst = line.get(1);
        int xSecond = line.get(2);
        int ySecond = line.get(3);

        if (xFirst == xSecond) {
            return Math.abs(x - xFirst) + calLowDimension(y, yFirst, ySecond);
        }

        return Math.abs(y - yFirst) + calLowDimension(x, xFirst, xSecond);
    }

    private static int calLowDimension(int i, int iFirst, int iSecond) {
        if (i < iFirst) {
            return iFirst - i;
        }
        if (i > iSecond) {
            return i - iSecond;
        }
        return 0;
    }

}