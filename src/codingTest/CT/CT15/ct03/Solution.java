package codingTest.CT.CT15.ct03;


//24-01-19(풀이) - 다시 풀기 - DP
public class Solution {
    public int solution(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MIN_VALUE;
            for (int j = 1; j <= k && i - j >= 0; j++) {
                dp[i] = Math.max(dp[i], dp[i-j] + arr[i]);
            }
        }
        return dp[n-1];
    }

}
