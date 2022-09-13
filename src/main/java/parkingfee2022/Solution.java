package parkingfee2022;

// 2022 블라인드 - 주차 요금 계산
// 220913 16:50 - 17:58

import java.util.*;

class Solution {
    int[] gfees = new int[4];
    int[] answer;
    Map<String, String> carsIn;
    Map<String, Integer> carsMinutes;

    public int[] solution(int[] fees, String[] records) {
        gfees = fees;
        carsIn = new HashMap<>();
        carsMinutes = new HashMap<>();

        //입출차내역 정리해서 carsMinutes로
        for (String record : records) {
            String[] tmp = record.split(" ");

            if (carsIn.containsKey(tmp[1])) {
                calculateMins(tmp[1], carsIn.get(tmp[1]), tmp[0]);
                carsIn.remove(tmp[1]);
            } else {
                carsIn.put(tmp[1], tmp[0]);
            }
        }

        if (carsIn.size() > 0) {
            carsIn.keySet().forEach(this::calculateMins);
        }

        //요금정산 부분
        answer = new int[carsMinutes.size()];
        List<String> carNumbers = new ArrayList<>(carsMinutes.keySet());
        Collections.sort(carNumbers);
        for (int i = 0; i < answer.length; i++) {
            answer[i] = calculateFee(carsMinutes.get(carNumbers.get(i)));
        }

        return answer;
    }

    private void calculateMins(String carName, String inTime, String outTime) {
        int mins = stringToTime(inTime, outTime);

        if (carsMinutes.containsKey(carName)) {
            carsMinutes.put(carName, carsMinutes.get(carName) + mins);
        } else {
            carsMinutes.put(carName, mins);
        }
    }

    private void calculateMins(String carName) {
        calculateMins(carName, carsIn.get(carName), "23:59");
    }

    private int stringToTime(String inTime, String outTime) {
        int[] in = Arrays.stream(inTime.split(":")).mapToInt(Integer::parseInt).toArray();
        int[] out = Arrays.stream(outTime.split(":")).mapToInt(Integer::parseInt).toArray();

        if (out[1] < in[1]) {
            out[0] -= 1;
            out[1] += 60;
        }

        out[1] -= in[1];
        out[0] -= in[0];

        return (out[0] * 60) + out[1];
    }

    private int calculateFee(int min) {
        if (min <= gfees[0]) {
            return gfees[1];
        }

        int result = min - gfees[0];
        if (result % gfees[2] > 0) {
            result /= gfees[2];
            result++;
        } else {
            result /= gfees[2];
        }

        return gfees[1] + (result * gfees[3]);
    }
}
