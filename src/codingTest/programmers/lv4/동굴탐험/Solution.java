package codingTest.programmers.lv4.동굴탐험;

import java.util.*;

class Solution {
    public boolean solution(int n, int[][] path, int[][] order) {
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : path) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        int[] prereq = new int[n];
        int[] next = new int[n];
        Arrays.fill(prereq, -1);
        Arrays.fill(next, -1);
        for (int[] o : order) {
            prereq[o[1]] = o[0];
            next[o[0]] = o[1];
        }
        if (prereq[0] != -1) {
            return false;
        }
        boolean[] visited = new boolean[n];
        boolean[] locked = new boolean[n];
        boolean[] delayed = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (prereq[i] != -1) {
                locked[i] = true;
            }
        }
        Queue<Integer> q = new ArrayDeque<>();
        visited[0] = true;
        q.offer(0);
        int count = 1;
        while (!q.isEmpty()) {
            int u = q.poll();
            if (next[u] != -1) {
                int b = next[u];
                locked[b] = false;
                if (delayed[b]) {
                    visited[b] = true;
                    q.offer(b);
                    count++;
                }
            }
            for (int v : adj[u]) {
                if (visited[v]) {
                    continue;
                }
                if (locked[v]) {
                    delayed[v] = true;
                } else {
                    visited[v] = true;
                    q.offer(v);
                    count++;
                }
            }
        }
        return count == n;
    }
}
