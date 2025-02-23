package codingTest.programmers.lv3.다단계칫솔판매;

import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, String> parent = new HashMap<>();
        Map<String, Integer> profit = new HashMap<>();

        for (int i = 0; i < enroll.length; i++) {
            parent.put(enroll[i], referral[i]);
            profit.put(enroll[i], 0);
        }

        for (int i = 0; i < seller.length; i++) {
            distributeProfit(seller[i], amount[i] * 100, parent, profit);
        }

        return Arrays.stream(enroll).mapToInt(profit::get).toArray();
    }

    private void distributeProfit(String seller, int amount, Map<String, String> parent, Map<String, Integer> profit) {
        while (!seller.equals("-") && amount > 0) {
            int distribute = amount / 10;
            profit.put(seller, profit.get(seller) + (amount - distribute));
            seller = parent.get(seller);
            amount = distribute;
        }
    }
}
