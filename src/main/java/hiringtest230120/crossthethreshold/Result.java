package hiringtest230120.crossthethreshold;
import java.util.*;

import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'getMaxBarrier' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY initialEnergy
     *  2. LONG_INTEGER th
     */

    public static int getMaxBarrier(List<Integer> initialEnergy, long th) {
        // Write your code here

        for (int i = 1; ; i++) {
            if (applyBarrier(i, initialEnergy) < th) {
                return i - 1;
            }
        }
    }

    private static long applyBarrier(int i, List<Integer> initialEnergy) {
        return initialEnergy.stream().mapToLong(element -> Math.max(element - i, 0)).sum();
    }

}
