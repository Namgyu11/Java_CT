package codingTest.CT.CT099.CT13.ct03;
//24-01-04(풀이) - 다시 풀기
public class Solution {
    final int mod = 100007;
    public int solution(int n, int m) {
        int[][] dp = new int[n+1][n+1];
        for(int i = 1; i <= n; i++) {
            dp[i][0] = dp[i][i] = 1;
            for(int j = 1; j < i; j++)
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % mod;
        }
        int answer = 0;
        for(int i = m-1; i < n; i++)
            answer = (answer + dp[n-1][i] * dp[i][m-1]) % mod;
        return answer * (1/(n-m+1));
    }
}
