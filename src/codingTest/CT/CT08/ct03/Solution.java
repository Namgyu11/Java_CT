package codingTest.CT.CT08.ct03;

// 23-12-01 (풀이) - 다시 풀어 보기 (dp)
public class Solution {
    public int solution(int N, int[] rewards) {
        if (N == 1) return rewards[0];
        if (N == 2) return Math.max(rewards[0], rewards[1]);

        int[] dp = new int[N];
        dp[0] = rewards[0];
        dp[1] = rewards[0];
        for (int i = 2; i < N - 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + rewards[i]);
        }
        int result = dp[N - 2];

        dp[0] = 0;
        dp[1] = rewards[1];
        for (int i = 2; i < N; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + rewards[i]);
        }
        result = Math.max(result, dp[N - 1]);

        return result;
    }
}
