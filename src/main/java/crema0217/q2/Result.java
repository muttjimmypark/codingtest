package crema0217.q2;
// 100%

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
     * Complete the 'findRange' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER num as parameter.
     */

    public static long findRange(int num) {
        int firstNum = Integer.toString(num).charAt(0) - '0';

        return findMax(num, firstNum) - findMin(num, firstNum);
    }

    private static long findMax(int num, int firstNum) {
        if (firstNum == 9) {
            long max = num;

            for (int i = 0; i <= 8; i++) {
                max = Math.max(max, changeWith(num, i, 9));
            }
            return max;
        }

        return changeWith(num, firstNum, 9);
    }

    private static long findMin(int num, int firstNum) {
        if (firstNum == 1) {
            long min = num;

            for (int i = 2; i <= 9; i++) {
                min = Math.min(min, changeWith(num, i, 0));
            }
            return min;
        }
        return changeWith(num, firstNum, 1);
    }

    private static long changeWith(int num, int a, int b) {
        String input = Integer.toString(num);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            int now = input.charAt(i) - '0';

            if (now == a) {
                sb.append(b);
                continue;
            }

            sb.append(now);
        }

        return Long.parseLong(sb.toString());
    }

}