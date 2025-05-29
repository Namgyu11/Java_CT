package codingTest.programmers.lv3.징검다리건너기;

import java.util.*;


class Solution {
    public int solution(int[] stones, int k) {
        int n = stones.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int minOfMax = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && stones[dq.peekLast()] <= stones[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);
            
            if (i >= k - 1) {
                int out = i - k;
                if (dq.peekFirst() == out) {
                    dq.pollFirst();
                }
                minOfMax = Math.min(minOfMax, stones[dq.peekFirst()]);
            }
        }
        
        return minOfMax;
    }
}
