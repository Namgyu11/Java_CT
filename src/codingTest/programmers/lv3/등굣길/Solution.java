package codingTest.programmers.lv3.등굣길;

class Solution {
    private static final int MOD = 1_000_000_007;
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[m][n];
        boolean[][] blocked = new boolean[m][n];
        for (int[] p : puddles) {
            blocked[p[0]-1][p[1]-1] = true;
        }
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (blocked[i][j]) {
                    dp[i][j] = 0;
                    continue;
                }
                if (i > 0) {
                    dp[i][j] = (dp[i][j] + dp[i-1][j]) % MOD;
                }
                if (j > 0) {
                    dp[i][j] = (dp[i][j] + dp[i][j-1]) % MOD;
                }
            }
        }
        return dp[m-1][n-1];
    }
}
