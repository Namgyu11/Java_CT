package inflearn.session02.ct11.트리_트리오_중간값;

import java.util.Arrays;

class Solution {
    static class Graph {
        int n, m;
        int[] head, to, next;
        int idx = 0;
        Graph(int n, int edges) {
            this.n = n;
            this.m = edges * 2;
            head = new int[n + 1];
            Arrays.fill(head, -1);
            to = new int[m];
            next = new int[m];
        }
        void addEdge(int u, int v) {
            to[idx] = v; next[idx] = head[u]; head[u] = idx++;
            to[idx] = u; next[idx] = head[v]; head[v] = idx++;
        }
    }

    public int solution(int n, int[][] edges) {
        Graph g = new Graph(n, n - 1);
        for (int[] e : edges) {
            g.addEdge(e[0], e[1]);
        }

        int[] parent = new int[n + 1];
        int[] order = new int[n];
        int top = 0;

        int[] stack = new int[n];
        int sp = 0;
        stack[sp++] = 1;
        parent[1] = 0;
        while (sp > 0) {
            int u = stack[--sp];
            order[top++] = u;
            for (int ei = g.head[u]; ei != -1; ei = g.next[ei]) {
                int v = g.to[ei];
                if (v == parent[u]) {
                    continue;
                }
                parent[v] = u;
                stack[sp++] = v;
            }
        }

        int[] down = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int u = order[i];
            int best = 0;
            for (int ei = g.head[u]; ei != -1; ei = g.next[ei]) {
                int v = g.to[ei];
                if (v == parent[u]) {
                    continue;
                }
                best = Math.max(best, down[v] + 1);
            }
            down[u] = best;
        }

        int[] up = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int u = order[i];

            int best1 = -1, best2 = -1;
            for (int ei = g.head[u]; ei != -1; ei = g.next[ei]) {
                int v = g.to[ei];
                if (v == parent[u]) {
                    continue;
                }
                int val = down[v] + 1;
                if (val > best1) { best2 = best1; best1 = val; }
                else if (val > best2) { best2 = val; }
            }

            for (int ei = g.head[u]; ei != -1; ei = g.next[ei]) {
                int v = g.to[ei];
                if (v == parent[u]) {
                    continue;
                }
                int use = (down[v] + 1 == best1 ? best2 : best1);
                if (use < 0) {
                    use = 0;
                }
                up[v] = 1 + Math.max(up[u], use);
            }
        }

        int ans = 0;
        for (int u = 1; u <= n; u++) {
            int deg = 0;
            int a = 0, b = 0, c = 0; // top1>=top2>=top3
            for (int ei = g.head[u]; ei != -1; ei = g.next[ei]) {
                int v = g.to[ei];
                int val;
                if (v == parent[u]) {
                    if (parent[u] == 0) {
                        continue;
                    }
                    val = up[u];
                } else {
                    val = down[v] + 1;
                }
                deg++;
                if (val >= a) { c = b; b = a; a = val; }
                else if (val >= b) { c = b; b = val; }
                else if (val > c) { c = val; }
            }
            if (deg >= 3) {
                ans = Math.max(ans, a + c);
            } else if (deg == 2) {
                ans = Math.max(ans, a);
            }
        }
        return ans;
    }
}
