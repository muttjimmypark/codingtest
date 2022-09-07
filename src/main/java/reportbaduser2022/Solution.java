package reportbaduser2022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    // 2022 블라인드 - 신고 결과 받기
    // 220905 13:50
    // 14:23
    // 15:12 (82분)

    public int[] solution(String[] id_list, String[] report, int k) {

        //Key를 신고한 userlist를 Value로 하는 Map 생성
        Map<String, List<String>> singoMap = new HashMap<>();
        for (String s : id_list) {
            singoMap.put(s, new ArrayList<>());
        }

        //각 Key의 Value를 확보
        for (String s : report) {
            String[] reportSplit = s.split(" ");
            List<String> whoReportKeyuser = singoMap.get(reportSplit[1]);

            if (!whoReportKeyuser.contains(reportSplit[0])) {
                whoReportKeyuser.add(reportSplit[0]);
                singoMap.put(reportSplit[1], whoReportKeyuser);
            }
        }

        //answer return할 준비
        int[] answer = new int[id_list.length];

        //singoMap에 없는 id_list의 index값을 확보
        Map<String, Integer> id_index = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            id_index.put(id_list[i], i);
        }

        //singoMap에서 신고횟수가 k회 이상인 Key에 대해서만 Value들의 answer를 1씩 증가
        for (String s : id_list) {
            List<String> reportUsers = singoMap.get(s);
            if (reportUsers.size() >= k) {
                for (String reportUser : reportUsers) {
                    answer[id_index.get(reportUser)]++;
                }
            }
        }

        return answer;
    }
}
