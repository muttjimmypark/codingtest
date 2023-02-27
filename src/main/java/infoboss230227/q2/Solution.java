package infoboss230227.q2;

import java.util.*;

class Solution {

    public int[] solution(int[] waiting) {

        return Arrays.stream(waiting).distinct().toArray();
    }
}