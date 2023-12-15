package codingTest.CT.CT10.ct05;

import java.util.*;

class Solution {
    public int solution(int N, int[][] edge) {
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] e : edge) {
            graph.get(e[0]).add(new int[]{e[1], e[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{0, 0});

        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        while(!pq.isEmpty()) {
            int[] current = pq.poll();
            int curNode = current[0];
            int curDist = current[1];

            if(dist[curNode] < curDist) continue;

            for(int[] node : graph.get(curNode)) {
                int nextNode = node[0];
                int nextDist = curDist + node[1];

                if(dist[nextNode] > nextDist) {
                    dist[nextNode] = nextDist;
                    pq.add(new int[]{nextNode, nextDist});
                }
            }
        }

        int maxDist = 0;
        int answer = 0;
        for(int i = 0; i < N; i++) {
            if(dist[i] == Integer.MAX_VALUE) continue;
            if(dist[i] > maxDist) {
                maxDist = dist[i];
                answer = i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

    }
}

