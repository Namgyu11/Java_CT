package codingTest.programmers.lv3.야근지수;

import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int w : works) {
            if (w > 0) {
                pq.offer(w);
            }
        }
        for (int i = 0; i < n && !pq.isEmpty(); i++) {
            int top = pq.poll() - 1;
            if (top > 0) {
                pq.offer(top);
            }
        }
        long answer = 0;
        while (!pq.isEmpty()) {
            long w = pq.poll();
            answer += w * w;
        }
        return answer;
    }
}
