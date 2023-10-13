package codingTest.CT.CT01.ct03;

public class Solution {
    public static int solution(int N) {
        if(N < 1 || N > 10){
            return 0;
        }else {
            int[] dp = new int[N+1];
            dp[0] = 0;
            dp[1] = 1;
            if(N > 1){
                dp[2] = 2;
                for(int i=3; i<=N; i++){
                    dp[i] = dp[i-1] + dp[i-2];
                }
            }
            return dp[N];
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(8));
    }
}
