package inflearn.session02.ct09.합승택시요금;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    static class Edge {
        int to, cost;
        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
    
    private int[] dijkstra(int n, int start, List<Edge>[] graph) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        dist[start] = 0;
        pq.offer(new int[]{start, 0});
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[0], curCost = cur[1];
            if (curCost > dist[curNode]) {
                continue;
            }
            for (Edge edge : graph[curNode]) {
                int next = edge.to;
                int nextCost = curCost + edge.cost;
                if (nextCost < dist[next]) {
                    dist[next] = nextCost;
                    pq.offer(new int[]{next, nextCost});
                }
            }
        }
        return dist;
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        List<Edge>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] fare : fares) {
            int c = fare[0], d = fare[1], f = fare[2];
            graph[c].add(new Edge(d, f));
            graph[d].add(new Edge(c, f));
        }
        
        int[] distFromS = dijkstra(n, s, graph);
        int[] distFromA = dijkstra(n, a, graph);
        int[] distFromB = dijkstra(n, b, graph);
        
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            if (distFromS[i] == Integer.MAX_VALUE || distFromA[i] == Integer.MAX_VALUE
                    || distFromB[i] == Integer.MAX_VALUE) {
                continue;
            }
            answer = Math.min(answer, distFromS[i] + distFromA[i] + distFromB[i]);
        }
        return answer;
    }
}
