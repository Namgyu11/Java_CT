package codingTest.programmers.lv4.매출하락;

import java.util.*;

class Solution {
    public int solution(int[] sales, int[][] links) {
        int n = sales.length;
        int[] parent = new int[n + 1];
        int[] childCnt = new int[n + 1];
        boolean[] hasChild = new boolean[n + 1];

        for (int[] e : links) {
            int a = e[0], b = e[1];
            parent[b] = a;
            childCnt[a]++;
        }
        for (int i = 1; i <= n; i++) {
            hasChild[i] = childCnt[i] > 0;
        }

        long[] sumMin = new long[n + 1];
        long[] minDelta = new long[n + 1];
        boolean[] anyAttend = new boolean[n + 1];
        Arrays.fill(minDelta, Long.MAX_VALUE);

        long[] dp0 = new long[n + 1];
        long[] dp1 = new long[n + 1];

        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (childCnt[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            if (hasChild[u]) {
                dp0[u] = sumMin[u] + (anyAttend[u] ? 0 : minDelta[u]);
            } else {
                dp0[u] = 0;
            }
            dp1[u] = (long) sales[u - 1] + sumMin[u];

            if (u != 1) {
                int p = parent[u];
                long m = Math.min(dp0[u], dp1[u]);
                sumMin[p] += m;
                if (dp1[u] <= dp0[u]) {
                    anyAttend[p] = true;
                }
                long d = dp1[u] - dp0[u];
                if (d < minDelta[p]) {
                    minDelta[p] = d;
                }
                if (--childCnt[p] == 0) {
                    q.add(p);
                }
            }
        }
        return (int) Math.min(dp0[1], dp1[1]);
    }
}
