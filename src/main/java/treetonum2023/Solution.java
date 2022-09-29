package treetonum2023;

class Solution {

    String[] numToString;

    public int[] solution(long[] numbers) {

        numToString = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numToString[i] = Long.toBinaryString(numbers[i]);
            if (numToString[i].length() % 2 == 0) {
                StringBuffer sb = new StringBuffer("");
                sb.append("0");
                sb.append(numToString[i]);
                numToString[i] = sb.toString();
            }
        }

        int[] answer = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (solve(numToString[i])) {
                answer[i] = 1;
                continue;
            }
            answer[i] = 0;
        }

        return answer;
    }

    private boolean solve(String num) {
        if (num.length() == 1) {
            return true;
        }

        if (num.length() % 2 == 0) {
            return false;
        }

        int mid = (num.length() / 2);
        if (num.charAt(mid) != '1') {
            return false;
        }

        String sub1 = num.substring(0, mid);
        String sub2 = num.substring(mid + 1, num.length());
        return solve(sub1) && solve(sub2);
    }
}