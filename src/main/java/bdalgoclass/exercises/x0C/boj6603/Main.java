package bdalgoclass.exercises.x0C.boj6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//public class Main {
//
//    static int[] outTmp;
//    static boolean[] flag;
//    static StringBuilder sb;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        outTmp = new int[6];
//        flag = new boolean[50];
//        sb = new StringBuilder();
//        while (true) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//
//            // valid k
//            if (st.nextToken().equals("0")) {
//                break;
//            }
//
//            Arrays.fill(outTmp, 0);
//            Arrays.fill(flag, false);
//            while (st.hasMoreTokens()) {
//                flag[Integer.parseInt(st.nextToken())] = true;
//            }
//
//            solution(0);
//            sb.append("\n");
//        }
//
//        System.out.println(sb);
//    }
//
//    private static void solution(int idx) {
//        if (idx == 6) {
//            for (int i = 0; i < 6; i++) {
//                sb.append(outTmp[i]).append(" ");
//            }
//            sb.append("\n");
//            return;
//        }
//
//        for (int i = idx == 0 ? 1 : outTmp[idx - 1]
//             ; i <= 49; i++) {
//            if (flag[i]) {
//                outTmp[idx] = i;
//                flag[i] = false;
//                solution(idx + 1);
//                flag[i] = true;
//            }
//        }
//    }
//}