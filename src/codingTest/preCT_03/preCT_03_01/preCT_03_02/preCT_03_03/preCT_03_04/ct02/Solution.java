package codingTest.preCT_03.preCT_03_01.preCT_03_02.preCT_03_03.preCT_03_04.ct02;

public class Solution {
    public static int solution(int[] A) {
        int[] dp = new int[A.length + 1];
        dp[0] = Integer.MIN_VALUE;
        dp[1] = A[0];

        for (int i = 2; i <=A.length; i++) {
            if(dp[i-1] < 0){
                dp[i] = A[i-1];
            }else {
                dp[i] = dp[i-1] + A[i-1];
            }
        }

        int answer = Integer.MIN_VALUE;
        for(int score : dp){
            answer = Math.max(answer,score);
        }
        if(answer < 0){
            answer = 0;
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}
