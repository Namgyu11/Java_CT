package codingTest.CT.CT11.ct04;
import java.util.*;
//23-12-22(풀이) - 다시 풀기 - DP

public class Solution {
    public int solution(int money, int[] chips) {
        int[] dp = new int[money + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int chip : chips) {
            for (int j = chip; j <= money; j++) {
                if (dp[j - chip] != Integer.MAX_VALUE)
                    dp[j] = Math.min(dp[j], dp[j - chip] + 1);
            }
        }

        return dp[money] == Integer.MAX_VALUE ? -1 : dp[money];
    }
}
