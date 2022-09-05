package countprimenumber2022;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    // 2022 블라인드 - k진수에서 소수 개수 구하기
    // 220905
    // 15:50 - 16:02
    // 18:46 - 20:20
    // 22:25 - 22:38 1차 풀이완, 테스트 1,11 런타임에러 테스트 14,16 실패
    // 22:43 isPrimeNumber가 Long타입 다루도록 하여 1,11 해결
    // 22:45 풀이 완


    public int solution(int n, int k) {
        //10진수 n을 k진수로 변환
        //Integer.valueOf(String.valueOf(n), k)로 변환할수 있지만
        //길이가 데이터타입 범위를 초과하므로 직접 메서드 작성
        String kJinsu = radixConvert(n, k);

        //0으로 split 하여 P값들 List 확보 + null string 제거
        List<String> pList = new ArrayList<>();
        Collections.addAll(pList, kJinsu.split("0"));
        while (pList.remove("")) {
        }

        //P가 솟수인지 T/F mapping 하여 count값 return
        return (int) pList.stream()
                .map(Long::parseLong)
                .filter(this::isPrimeNumber)
                .count();
    }

    private String radixConvert(int n, int k) {
        if (n < k) {
            return String.valueOf(n);
        }

        return radixConvert(n / k, k) + String.valueOf(n % k);
    }

    private boolean isPrimeNumber(Long p) {
        if (p < 2) {
            return false;
        }

        if (p == 2) {
            return true;
        }

        // 제곱근에 딱 해당하는경우를 배제해야... (테스트 14,16 통과)
        for (int i = 2; i < Math.sqrt(p) + 1; i++) {
            if (p % i == 0) {
                return false;
            }
        }
        return true;

    }
}