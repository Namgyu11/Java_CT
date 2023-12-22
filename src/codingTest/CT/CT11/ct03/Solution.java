package codingTest.CT.CT11.ct03;

//23-12-22(풀이) - 다시 풀기 - DP

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean solution(String s, String[] words) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

}
