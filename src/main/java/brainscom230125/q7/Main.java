package brainscom230125.q7;

import java.util.Arrays;

public class Main {

    static int[] solution(long a) {
        long aa = a;
        int[] result = new int[10];
        Arrays.fill(result, 0);

        while (aa > 0) {
            String input = String.valueOf(aa);
            int end = input.charAt(input.length() - 1) - '0';
            result[end]++;
            aa /= 10;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] tmp = solution(1);

        for (int i = 0; i < 10; i++) {
            System.out.println(tmp[i]);
        }

        System.out.println();

    }

    void solution2() {
        int[] a = new int[4];
        Arrays.fill(a, 100);

        int[] b = new int[5];
        for (int i = 0; i < 5; i++) {
            if (i == 4) {
                b[i] = 10;
                continue;
            }
            b[i] = a[i];
        }
    }
}
