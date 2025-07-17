package codingTest.programmers.lv4.무지_먹방;

import java.util.*;

class Solution {
    public int solution(int[] food_times, long k) {
        int n = food_times.length;
        long total = 0;
        for (int t : food_times) {
            total += t;
        }
        if (total <= k) {
            return -1;
        }

        PriorityQueue<Food> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.offer(new Food(i, food_times[i]));
        }

        long eaten = 0;       
        long prevTime = 0;    

        while (!pq.isEmpty()) {
            int size = pq.size();
            long currTime = pq.peek().time;
            long diff = currTime - prevTime;
            long spend = diff * size;
            if (spend <= k) {
                k -= spend;
                prevTime = currTime;
                while (!pq.isEmpty() && pq.peek().time == currTime) {
                    pq.poll();
                }
            } else {
                break;
            }
        }

        List<Food> remain = new ArrayList<>(pq);
        remain.sort(Comparator.comparingInt(f -> f.index));

        int idx = (int)(k % remain.size());
        return remain.get(idx).index + 1;
    }

    private static class Food implements Comparable<Food> {
        int index;
        int time;
        Food(int idx, int t) {
            this.index = idx;
            this.time = t;
        }
        @Override
        public int compareTo(Food o) {
            return Integer.compare(this.time, o.time);
        }
    }
}
