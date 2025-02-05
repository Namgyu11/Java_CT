package codingTest.programmers.부대복귀;

import java.util.*;

public class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }

        int[] distances = new int[n + 1];
        Arrays.fill(distances, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(destination);
        distances[destination] = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int next : graph.get(curr)) {
                if (distances[next] == -1) {
                    distances[next] = distances[curr] + 1;
                    queue.add(next);
                }
            }
        }

        int[] result = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            result[i] = distances[sources[i]];
        }

        return result;
    }
}

