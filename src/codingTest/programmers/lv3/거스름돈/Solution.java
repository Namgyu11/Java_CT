package codingTest.programmers.lv3.거스름돈;

class Solution {
    public int solution(int n, int[] money) {
        final int MOD = 1_000_000_007;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int coin : money) {
            for (int amt = coin; amt <= n; amt++) {
                dp[amt] = (dp[amt] + dp[amt - coin]) % MOD;
            }
        }
        return (int) dp[n];
    }
}
