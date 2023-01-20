package hiringtest230120.stringconversion;

import static java.util.stream.Collectors.joining;


class Result {

    /*
     * Complete the 'getOptimalString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String getOptimalString(String s) {
        // Write your code here
        int sLength = s.length();

        int zeroCount = 0;
        int oneCount = 0;
        for (int i = 0; i < sLength; i++) {
            if (s.charAt(i) == '0') {
                zeroCount++;
                continue;
            }
            oneCount++;
        }

        if (zeroCount == 0) {
            return s;
        }


        StringBuilder result = new StringBuilder();
        for (int i = 0; zeroCount != 0; i++) {
            if (i % 2 == 0
                    && oneCount != 0) {
                result.append("1");
                oneCount--;
                continue;
            }
            result.append("0");
            zeroCount--;
        }

        if (sLength % 2 == 0) {
            result.reverse();
        }

        return result.toString();
    }

}