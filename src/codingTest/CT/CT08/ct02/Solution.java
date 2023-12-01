package codingTest.CT.CT08.ct02;

// 23-12-01 (풀이) - 다시 풀어 보기 (dp)
public class Solution {
    public int solution(int depth, int n, int[][] blocks) {
        int[][] dp = new int[depth + 1][blocks[0].length];
        dp[0] = blocks[0].clone();

        for (int d = 1; d <= depth; d++) {
            for (int i = 0; i < blocks[0].length; i++) {
                dp[d][i] = blocks[d][i] + Math.min(dp[d - 1][i],
                        Math.min(i > 0 ? dp[d - 1][i - 1] : Integer.MAX_VALUE,
                                i < blocks[0].length - 1 ? dp[d - 1][i + 1] : Integer.MAX_VALUE));
            }
        }
        return dp[depth][n];
    }
}
