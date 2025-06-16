package codingTest.programmers.lv3.최적의_행렬_곱셈;

class Solution {
    public int solution(int[][] matrix_sizes) {
        int n = matrix_sizes.length;
        int[] p = new int[n + 1];
        for (int i = 0; i < n; i++) {
            p[i] = matrix_sizes[i][0];
        }
        p[n] = matrix_sizes[n - 1][1];
        
        long[][] dp = new long[n + 1][n + 1];
        
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i + len - 1 <= n; i++) {
                int j = i + len - 1;
                dp[i][j] = Long.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    long cost = dp[i][k] + dp[k + 1][j] + 
                                (long)p[i - 1] * p[k] * p[j];
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                    }
                }
            }
        }
        return (int)dp[1][n];
    }
}
