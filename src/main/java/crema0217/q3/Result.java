package crema0217.q3;
// 2/10

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'maxLength' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER k
     */
    static int tmpSum;
    static int tmpCount;
    static int gk;
    static int result;

    public static int maxLength(List<Integer> a, int k) {
        gk = k;
        tmpSum = 0;
        tmpCount = 0;
        result = 0;
        backTracking(0, a);

        return result;
    }

    private static void backTracking(int idx, List<Integer> a) {
        if (idx == a.size()) {
            if (tmpSum == gk) {
                result = Math.max(result, tmpCount);
            }

            return;
        }

        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                //안쓰는경우
                backTracking(idx + 1, a);
                continue;
            }

            //쓰는경우
            tmpCount++;
            tmpSum += a.get(idx);
            backTracking(idx + 1, a);
            tmpCount--;
            tmpSum -= a.get(idx);
        }

    }


}