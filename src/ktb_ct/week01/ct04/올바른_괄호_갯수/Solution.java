package ktb_ct.week01.ct04.올바른_괄호_갯수;

class Solution {
    public int solution(int n) {
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            long sum = 0;
            for (int j = 0; j < i; j++) {
                sum += dp[j] * dp[i - 1 - j];
            }
            dp[i] = sum;
        }
        return (int) dp[n];
    }
}
