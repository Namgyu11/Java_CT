package codingTest.CT.CT04.ct04;

import java.util.*;

class Solution {
    class Job implements Comparable<Job> {
        int start, time, idx;

        public Job(int start, int time, int idx) {
            this.start = start;
            this.time = time;
            this.idx = idx;
        }

        @Override
        public int compareTo(Job o) {
            if (this.start == o.start) {
                if (this.time == o.time) return this.idx - o.idx;
                else return this.time - o.time;
            }
            else return this.start - o.start;
        }
    }

    public int[] solution(int[] start, int[] time) {
        PriorityQueue<Job> startPQ = new PriorityQueue<>();
        PriorityQueue<Job> timePQ = new PriorityQueue<>(Comparator.comparingInt((Job job) -> job.time).thenComparingInt(job -> job.idx));

        for (int i = 0; i < start.length; i++) {
            startPQ.add(new Job(start[i], time[i], i));
        }

        List<Integer> answer = new ArrayList<>();
        int currentTime = 0;

        while (!startPQ.isEmpty() || !timePQ.isEmpty()) {
            while (!startPQ.isEmpty() && startPQ.peek().start <= currentTime) {
                timePQ.add(startPQ.poll());
            }

            if (!timePQ.isEmpty()) {
                Job job = timePQ.poll();
                currentTime += job.time;
                answer.add(job.idx);
            } else if (!startPQ.isEmpty()) {
                currentTime = startPQ.peek().start;
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
