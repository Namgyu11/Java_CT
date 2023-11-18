package codingTest.CT.CT05.ct05;

import java.util.*;
//23-11-10 (풀이) @@@@@@@@ 다시 풀기 @@@@@@@@@
class Fryer implements Comparable<Fryer> {
    int fryTime;
    int cleanTime;
    int nextAvailableTime;

    public Fryer(int fryTime, int cleanTime) {
        this.fryTime = fryTime;
        this.cleanTime = cleanTime;
        this.nextAvailableTime = fryTime;
    }

    @Override
    public int compareTo(Fryer other) {
        return Integer.compare(this.nextAvailableTime, other.nextAvailableTime);
    }
}

class Solution {
    public int solution(int N, int M, int[] fry, int[] clean) {
        PriorityQueue<Fryer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.add(new Fryer(fry[i], clean[i]));
        }

        for (int i = 0; i < M - 1; i++) {
            Fryer fryer = pq.poll();
            fryer.nextAvailableTime += fryer.fryTime + fryer.cleanTime;
            pq.add(fryer);
        }

        return pq.poll().nextAvailableTime;
    }
}

