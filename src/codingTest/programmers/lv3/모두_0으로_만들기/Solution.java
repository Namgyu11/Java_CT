package codingTest.programmers.lv3.모두_0으로_만들기;

import java.util.*;

class Solution {
    public long solution(int[] a, int[][] edges) {
        int n = a.length;
        long total = 0;
        for (int v : a) {
            total += v;
        }
        if (total != 0) {
            return -1;
        }
        
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        
        int[] parent = new int[n];
        parent[0] = -1;
        int[] order = new int[n];
        int idx = 0;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        while (!q.isEmpty()) {
            int u = q.poll();
            order[idx++] = u;
            for (int v : adj[u]) {
                if (v == parent[u]) {
                    continue;
                }
                parent[v] = u;
                q.add(v);
            }
        }
        
        long ops = 0;
        for (int i = n - 1; i > 0; i--) {
            int u = order[i];
            int p = parent[u];
            ops += Math.abs(a[u]);
            a[p] += a[u]; 
            a[u] = 0;
        }
        return ops;
    }
}
