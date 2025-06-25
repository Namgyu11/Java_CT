package codingTest.programmers.lv3.숫자_타자_대회;

import java.util.*;

class Solution {
    static final int INF = Integer.MAX_VALUE / 2;
    static final int[][] POS = {
        {0,0},{0,1},{0,2},
        {1,0},{1,1},{1,2},
        {2,0},{2,1},{2,2},
        {3,1}  
    };
    private int cost(int from, int to) {
        if (from == to) {
            return 1;
        }
        int dr = Math.abs(POS[from][0] - POS[to][0]);
        int dc = Math.abs(POS[from][1] - POS[to][1]);
        int diag = Math.min(dr, dc);
        int straight = Math.max(dr, dc) - diag;
        return diag * 3 + straight * 2;
    }
    
    public int solution(String numbers) {
        int N = numbers.length();
        int[][] dp = new int[10][10];
        for (int i = 0; i < 10; i++) {
            Arrays.fill(dp[i], INF);
        }
        dp[3][5] = 0;
        
        for (int idx = 0; idx < N; idx++) {
            int d = numbers.charAt(idx) == '0' ? 9 : numbers.charAt(idx) - '1';
            int[][] next = new int[10][10];
            for (int i = 0; i < 10; i++) {
                Arrays.fill(next[i], INF);
            }
            
            for (int l = 0; l < 10; l++) {
                for (int r = 0; r < 10; r++) {
                    int cur = dp[l][r];
                    if (cur >= INF) {
                        continue;
                    }
                    if (r == d) {
                        next[l][r] = Math.min(next[l][r], cur + 1);
                    } else if (l == d) {
                        next[l][r] = Math.min(next[l][r], cur + 1);
                    } else {
                        int c1 = cost(l, d);
                        next[d][r] = Math.min(next[d][r], cur + c1);
                       
                        int c2 = cost(r, d);
                        next[l][d] = Math.min(next[l][d], cur + c2);
                    }
                }
            }
            dp = next;
        }
        int answer = INF;
        for (int l = 0; l < 10; l++) {
            for (int r = 0; r < 10; r++) {
                answer = Math.min(answer, dp[l][r]);
            }
        }
        return answer;
    }
}
