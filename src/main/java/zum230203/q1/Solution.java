package zum230203.q1;

class Solution {
    public long solution(long n) {
        long answer = 0;
        long mx = (n * n) + n;

        for (long i = n; i < mx; i++) {
            if (i / n == i % n) {
                answer += i;
            }
        }
        return answer;
    }
}