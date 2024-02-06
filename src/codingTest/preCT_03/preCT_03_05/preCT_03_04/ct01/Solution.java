package codingTest.preCT_03.preCT_03_05.preCT_03_04.ct01;


//23-10-08(풀이) -- 다시 풀기 !!
public class Solution {
    public static int solution(int n, int k) {

        int mod = (int)1e9 + 7;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i - k >= 0) {
                dp[i] += dp[i - k];
                dp[i] %= mod;
            }
            if (i - 1 >= 0) {
                dp[i] += dp[i - 1];
                dp[i] %= mod;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        int k = 3;
        System.out.println(solution(n,k));
    }
}
