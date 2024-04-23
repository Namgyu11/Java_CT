package codingTest.CT.CT_FINAL.ct09;

import java.util.*;

//24-03-23 다시 풀기 -- 다익스트라
public class Solution {
    public int solution(int n, int[] cost, int[][] line) {
        int[] minCost = new int[n+1];
        boolean[] visited = new boolean[n+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            minCost[i] = (i == 0) ? 0 : Integer.MAX_VALUE;
            pq.offer(new int[]{i, minCost[i]});
        }

        for (int i = 0; i < n; i++) {
            graph.get(0).add(new int[]{i+1, cost[i]});
            graph.get(i+1).add(new int[]{0, cost[i]});
        }

        for (int[] l : line) {
            graph.get(l[0]+1).add(new int[]{l[1]+1, l[2]});
            graph.get(l[1]+1).add(new int[]{l[0]+1, l[2]});
        }

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int nodeCost = current[1];

            if (visited[node]) continue;
            visited[node] = true;

            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                int edgeCost = neighbor[1];

                if (!visited[nextNode] && minCost[nextNode] > edgeCost) {
                    minCost[nextNode] = edgeCost;
                    pq.offer(new int[]{nextNode, edgeCost});
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer += minCost[i];
        }

        return answer;
    }
}