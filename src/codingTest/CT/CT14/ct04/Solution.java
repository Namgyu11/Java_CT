package codingTest.CT.CT14.ct04;
import java.util.*;


//24-01-11 풀이 - 다시 풀기

public class Solution {
    public int solution(int N, int[][] edges) {
        int[] d = new int[N + 1];
        List<List<Integer>> graph = new ArrayList<>();
        List<List<Integer>> shortcut = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            d[i] = Integer.MAX_VALUE;
            graph.add(new ArrayList<>());
            shortcut.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= Math.min(i + 5, N); j++) {
                graph.get(i).add(j);
            }
        }

        for (int[] edge : edges) {
            shortcut.get(edge[0]).add(edge[1]);
        }

        d[1] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph.get(cur)) {
                if (d[next] > d[cur] + 1) {
                    d[next] = d[cur] + 1;
                    queue.add(next);
                }
            }
            for (int next : shortcut.get(cur)) {
                if (d[next] > d[cur]) {
                    d[next] = d[cur];
                    queue.add(next);
                }
            }
        }

        for (int[] edge : edges) {
            if (d[edge[1]] > d[edge[0]]) {
                d[edge[1]] = d[edge[0]];
            }
        }

        return d[N] / 2 + d[N] % 2;
    }
}
