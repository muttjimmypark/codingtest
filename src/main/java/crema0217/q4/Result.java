package crema0217.q4;
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
     * Complete the 'longestChain' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING_ARRAY words as parameter.
     */

    static int[] saved;

    public static int longestChain(List<String> words) {
        int mx = 0;
        saved = new int[words.size()];
        Arrays.fill(saved, 0);

        for (int i = 0; i < words.size(); i++) {
            saved[i] = countChain(i, words);
            mx = Math.max(mx, saved[i]);
        }

        return mx;
    }

    private static int countChain(int idx, List<String> words) {
        if (saved[idx] != 0) {
            return saved[idx];
        }

        String now = words.get(idx);

        if (now.length() == 1) {
            saved[idx] = 1;
            return 1;
        }

        int nowMx = 1;
        for (int i = 0; i < now.length(); i++) {
            String tmp = removeOne(now, i);

            if (words.contains(tmp)) {
                nowMx = Math.max(nowMx, 1 + countChain(words.indexOf(tmp), words));
            }
        }

        saved[idx] = nowMx;
        return nowMx;
    }

    private static String removeOne(String now, int i) {
        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < now.length(); j++) {
            if (j == i) {
                continue;
            }

            sb.append(now.charAt(i));
        }

        return sb.toString();
    }

}

/**
 * 사전을 나타내는 단어 배열이 주어지면, 문자를 한 번에 하나씩 제거할 때
 * 각 단어가 사전에서 다른 단어로 만들어질 수 있는지 확인하기 위해 각 단어를 테스트합니다.
 * 각 단어는 문자열 체인의 첫 번째 요소를 나타내므로 문자열 체인 길이 1로 시작합니다.
 * 문자가 제거될 때마다 문자열 체인을 1씩 늘립니다.
 * 문자를 제거하려면 결과 단어가 원래 사전에 있어야 합니다.
 * 지정된 사전에 대해 달성할 수 있는 가장 긴 문자열 체인을 결정합니다.
 */