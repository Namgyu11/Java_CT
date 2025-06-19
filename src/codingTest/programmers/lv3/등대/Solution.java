package codingTest.programmers.lv3.등대;

import java.util.*;

class Solution {
    List<Integer>[] adj;
    int[][] dp;
    boolean[] seen;
    
    public int solution(int n, int[][] lighthouse) {
        adj = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : lighthouse) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        dp = new int[n+1][2];
        seen = new boolean[n+1];
        dfs(1);
        return Math.min(dp[1][0], dp[1][1]);
    }

    void dfs(int u) {
        seen[u] = true;
        dp[u][0] = 0;
        dp[u][1] = 1;  
        for (int v : adj[u]) {
            if (!seen[v]) {
                dfs(v);
                dp[u][0] += dp[v][1];
                dp[u][1] += Math.min(dp[v][0], dp[v][1]);
            }
        }
    }
}
