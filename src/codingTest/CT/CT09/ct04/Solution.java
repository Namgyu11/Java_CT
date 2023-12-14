package codingTest.CT.CT09.ct04;

import java.util.*;

//23-12-08(풇이) - 다시 풀기 - 최소 신장 트리

class Solution {

    int[] x, y;
    boolean[] visited;
    int[][] dist;

    public int solution(int[] x, int[] y) {
        this.x = x;
        this.y = y;

        int n = x.length;
        visited = new boolean[n];
        dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]);
            }
        }

        return prim();
    }

    int prim() {
        int[] minDist = new int[x.length];
        Arrays.fill(minDist, Integer.MAX_VALUE);

        minDist[0] = 0;
        int res = 0;

        for (int i = 0; i < x.length; i++) {
            int u = -1;
            for (int v = 0; v < x.length; v++) {
                if (!visited[v] && (u == -1 || minDist[u] > minDist[v])) {
                    u = v;
                }
            }

            visited[u] = true;
            res += minDist[u];

            for (int v = 0; v < x.length; v++) {
                minDist[v] = Math.min(minDist[v], dist[u][v]);
            }
        }

        return res;
    }
}
