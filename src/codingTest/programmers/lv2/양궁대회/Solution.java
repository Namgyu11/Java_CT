package codingTest.programmers.lv2.양궁대회;

import java.util.*;

class Solution {
    static int maxDiff = 0;
    static int[] bestAnswer = null;
    static int nArrows;
    static int[] apeach;
    
    public int[] solution(int n, int[] info) {
        nArrows = n;
        apeach = info;
        maxDiff = 0;
        bestAnswer = new int[11];
        int[] current = new int[11];
        
        dfs(0, 0, current);

        if (maxDiff <= 0) {
            return new int[]{-1};
        }
        return bestAnswer;
    }
    
    private void dfs(int idx, int sum, int[] current) {
        if (idx == 11) {
            if (sum != nArrows) {
                return;
            }
            int[] scores = calculateScore(current);
            int diff = scores[0] - scores[1];
            if (diff > maxDiff) {
                maxDiff = diff;
                bestAnswer = current.clone();
            } else if (diff == maxDiff && diff > 0) {
                if (isBetter(current, bestAnswer)) {
                    bestAnswer = current.clone();
                }
            }
            return;
        }
        
        for (int i = 0; i <= nArrows - sum; i++) {
            current[idx] = i;
            dfs(idx + 1, sum + i, current);
            current[idx] = 0;
        }
    }
    
    private int[] calculateScore(int[] ryan) {
        int ryanScore = 0;
        int apeachScore = 0;
        for (int i = 0; i < 11; i++) {
            int score = 10 - i;
            if (ryan[i] == 0 && apeach[i] == 0) {
                continue;
            }
            if (ryan[i] > apeach[i]) {
                ryanScore += score;
            } else {
                apeachScore += score;
            }
        }
        return new int[]{ryanScore, apeachScore};
    }
    
    private boolean isBetter(int[] current, int[] best) {
        for (int i = 10; i >= 0; i--) {
            if (current[i] > best[i]) {
                return true;
            } else if (current[i] < best[i]) {
                return false;
            }
        }
        return false;
    }
}