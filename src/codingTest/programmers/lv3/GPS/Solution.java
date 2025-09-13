package codingTest.programmers.lv3.GPS;

import java.util.*;

class Solution {
    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        List<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : edge_list) {
            int a = e[0], b = e[1];
            adj[a].add(b);
            adj[b].add(a);
        }
        int INF = 1_000_000_000;
        int[][] dp = new int[k][n + 1];
        for (int i = 0; i < k; i++) {
            Arrays.fill(dp[i], INF);
        }
        dp[0][gps_log[0]] = 0;
        for (int t = 1; t < k; t++) {
            for (int v = 1; v <= n; v++) {
                int best = dp[t - 1][v];
                for (int u : adj[v]) {
                    best = Math.min(best, dp[t - 1][u]);
                }
                if (best < INF) {
                    dp[t][v] = best + (gps_log[t] == v ? 0 : 1);
                }
            }
        }
        int ans = dp[k - 1][gps_log[k - 1]];
        return ans >= INF ? -1 : ans;
    }
}
