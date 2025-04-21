package codingTest.programmers.lv3.상담원인원;

import java.util.*;

class Solution {
    static class Request {
        int time, dur;
        Request(int time, int dur) {
            this.time = time;
            this.dur = dur;
        }
    }

    int k, n;
    List<List<Request>> reqsByCat;
    int best = Integer.MAX_VALUE;
    int[] mentors;

    public int solution(int k, int n, int[][] reqs) {
        this.k = k;
        this.n = n;
        reqsByCat = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            reqsByCat.add(new ArrayList<>());
        }
        for (int[] r : reqs) {
            int a = r[0], b = r[1], c = r[2] - 1;
            reqsByCat.get(c).add(new Request(a, b));
        }
        mentors = new int[k];
        dfsCompose(0, n);
        return best;
    }

    void dfsCompose(int idx, int rem) {
        if (idx == k - 1) {
            mentors[idx] = rem;
            evaluate();
            return;
        }
        for (int m = 1; m <= rem - (k - idx - 1); m++) {
            mentors[idx] = m;
            dfsCompose(idx + 1, rem - m);
        }
    }

    void evaluate() {
        int totalWait = 0;
        for (int c = 0; c < k; c++) {
            totalWait += simulate(reqsByCat.get(c), mentors[c]);
            if (totalWait >= best) {
                return;
            }
        }
        best = totalWait;
    }

    int simulate(List<Request> list, int m) {
        if (list.isEmpty()) {
            return 0;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int wait = 0;
        for (Request req : list) {
            int t = req.time, d = req.dur;
            if (pq.size() < m) {
                pq.offer(t + d);
            } else {
                int avail = pq.peek();
                if (avail <= t) {
                    pq.poll();
                    pq.offer(t + d);
                } else {
                    wait += avail - t;
                    pq.poll();
                    pq.offer(avail + d);
                }
            }
        }
        return wait;
    }
}
