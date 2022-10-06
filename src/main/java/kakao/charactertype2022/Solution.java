package kakao.charactertype2022;

//221006 13:16 - 13:45

class Solution {
    String[] types;
    int[] scores;

    public String solution(String[] survey, int[] choices) {
        types = new String[]{"RT", "CF", "JM", "AN"};
        scores = new int[4];
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < choices.length; i++) {
            makeScore(survey[i], choices[i]);
        }

        for (int i = 0; i < 4; i++) {
            answer.append(makeAnswer(i));
        }

        return answer.toString();
    }

    private char makeAnswer(int i) {
        if (scores[i] > 0) {
            return types[i].charAt(1);
        }
        return types[i].charAt(0);
    }

    private void makeScore(String survey, int choice) {
        int toMiddle = choice - 4;

        if (toMiddle < 0) {
            goScore(survey.charAt(0), toMiddle * (-1));
            return;
        }

        if (toMiddle > 0) {
            goScore(survey.charAt(1), toMiddle);
            return;
        }
    }

    private void goScore(char type, int score) {
        if (type == 'R') {
            scores[0] += (score * -1);
            return;
        }
        if (type == 'T') {
            scores[0] += score;
            return;
        }
        if (type == 'C') {
            scores[1] += (score * -1);
            return;
        }
        if (type == 'F') {
            scores[1] += score;
            return;
        }
        if (type == 'J') {
            scores[2] += (score * -1);
            return;
        }
        if (type == 'M') {
            scores[2] += score;
            return;
        }
        if (type == 'A') {
            scores[3] += (score * -1);
            return;
        }
        if (type == 'N') {
            scores[3] += score;
            return;
        }
    }
}