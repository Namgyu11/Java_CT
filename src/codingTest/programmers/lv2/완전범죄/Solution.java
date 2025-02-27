package codingTest.programmers.lv2.완전범죄;

import java.util.*;

class Solution {
    int[][][] dp;
    int L, N_A, N_B;
    int INF = 1000000000;

    public int solution(int[][] info, int n, int m) {
        L = info.length;
        N_A = n;
        N_B = m;

        dp = new int[L + 1][N_A][N_B];
        for (int i = 0; i <= L; i++) {
            for (int a = 0; a < N_A; a++) {
                Arrays.fill(dp[i][a], -1);
            }
        }

        int ans = rec(0, 0, 0, info);
        return ans >= INF ? -1 : ans;
    }

    private int rec(int i, int a, int b, int[][] info) {
        if (i == L) {
            if (a < N_A && b < N_B) {
                return a;
            }
            return INF;
        }
        if (dp[i][a][b] != -1) {
            return dp[i][a][b];
        }

        int res = INF;
        int A_cost = info[i][0];
        int B_cost = info[i][1];

        if (a + A_cost < N_A) {
            res = Math.min(res, rec(i + 1, a + A_cost, b, info));
        }
        if (b + B_cost < N_B) {
            res = Math.min(res, rec(i + 1, a, b + B_cost, info));
        }

        dp[i][a][b] = res;
        return res;
    }
}
