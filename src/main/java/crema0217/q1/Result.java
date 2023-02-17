package crema0217.q1;
// 10/15


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
     * Complete the 'getFinalString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String getFinalString(String s) {

        String my = mySolution(s);

        if (my.length() == 0) {
            return "-1";
        }

        return my;

    }

    private static String mySolution(String s) {

        if (s.equals("AWS")) {
            return "";
        }

        if (s.length() < 3) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= s.length(); i++) {
            if (i == s.length()) {
                return sb.toString();
            }
            if (i > s.length() - 3) {
                sb.append(s.charAt(i));
                continue;
            }

            String now = s.substring(i, i + 3);

            if (now.equals("AWS")) {
                sb.append(s.substring(i + 3));

                return mySolution(sb.toString());
            }

            sb.append(s.charAt(i));
        }

        return "";
    }

}