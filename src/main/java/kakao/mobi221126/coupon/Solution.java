package kakao.mobi221126.coupon;

import java.util.*;

class Solution {
    int days;
    Map<String, Integer> customerCoupon;
    int gk;

    public int solution(String[] id_list, int k) {
        days = id_list.length;
        customerCoupon = new HashMap<>();
        gk = k;

        for (String dailyCustomers : id_list) {
            dailySolve(dailyCustomers);
        }

        int answer = 0;
        for (Integer value : customerCoupon.values()) {
            System.out.println("value = " + value);
            answer += value;
        }
        return answer;
    }

    private void dailySolve(String dailyCustomers) {
        Set<String> customers = new HashSet<>(Arrays.asList(dailyCustomers.split(" ")));

        for (String customer : customers) {
            if (customerCoupon.containsKey(customer)) {
                Integer tmp = customerCoupon.get(customer);
                tmp += 1;
                customerCoupon.put(customer, Math.min(gk, tmp));
                continue;
            }

            customerCoupon.put(customer, 1);
        }
    }
}