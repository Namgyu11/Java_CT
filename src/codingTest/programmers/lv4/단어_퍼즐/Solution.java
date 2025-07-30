package codingTest.programmers.lv4.단어_퍼즐;

import java.util.*;

class Solution {
    public int solution(String[] strs, String t) {
        int T = t.length();
        int INF = Integer.MAX_VALUE / 2;
        int[] dp = new int[T + 1];
        Arrays.fill(dp, INF);
        dp[T] = 0;
        Map<Integer, List<String>> byLen = new HashMap<>();
        for (String s : strs) {
            byLen.computeIfAbsent(s.length(), k -> new ArrayList<>()).add(s);
        }
        for (int i = T - 1; i >= 0; i--) {
            for (int len : byLen.keySet()) {
                if (i + len > T) {
                    continue;
                }
                String sub = t.substring(i, i + len);
                for (String piece : byLen.get(len)) {
                    if (piece.equals(sub)) {
                        dp[i] = Math.min(dp[i], 1 + dp[i + len]);
                    }
                }
            }
        }
        return dp[0] >= INF ? -1 : dp[0];
    }
}
