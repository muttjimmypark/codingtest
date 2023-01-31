package bdalgoclass.exercises.x0B.boj17478;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static StringBuilder sb;
    static String[] messages;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        sb = new StringBuilder();
        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.").append("\n");

        messages = new String[6];
        messages[0] = "\"재귀함수가 뭔가요?\"";
        messages[1] = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
        messages[2] = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
        messages[3] = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
        messages[4] = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
        messages[5] = "라고 답변하였지.";

        solution(0);
        System.out.println(sb);
    }

    private static void solution(int x) {

        StringBuilder dash = new StringBuilder();
        for (int i = 0; i < x; i++) {
            dash.append("____");
        }

        sb.append(dash).append(messages[0]).append("\n");

        if (x == n) {
            sb.append(dash).append(messages[4]).append("\n");
            sb.append(dash).append(messages[5]).append("\n");
            return;
        }

        for (int i = 1; i < 4; i++) {
            sb.append(dash).append(messages[i]).append("\n");
        }
        solution(x + 1);
        sb.append(dash).append(messages[5]).append("\n");

    }
}