package codingTest.programmers.lv3.주사위고르기;

import java.util.*;
class Solution {
    int n;
    int[][] diceArr;
    int k;
    long bestWins;
    List<Integer> bestChoice;
    
    public int[] solution(int[][] dice) {
        n = dice.length;
        diceArr = dice;
        k = n / 2;
        bestWins = -1;
        bestChoice = new ArrayList<>();

        combination(0, new ArrayList<>());
        Collections.sort(bestChoice);
        int[] answer = new int[bestChoice.size()];

        for (int i = 0; i < bestChoice.size(); i++) {
            answer[i] = bestChoice.get(i) + 1;
        }
        return answer;
    }
    
    void combination(int start, List<Integer> cur) {
        if(cur.size() == k) {
            Set<Integer> set = new HashSet<>(cur);
            List<Integer> comp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (!set.contains(i)) {
                    comp.add(i);
                }
            }
            long wins = countWins(cur, comp);
            if(wins > bestWins) {
                bestWins = wins;
                bestChoice = new ArrayList<>(cur);
            }
            return;
        }
        for (int i = start; i < n; i++) {
            cur.add(i);
            combination(i+1, cur);
            cur.remove(cur.size()-1);
        }
    }
    
    long countWins(List<Integer> aIndices, List<Integer> bIndices) {
        long[] distA = getDistribution(aIndices);
        long[] distB = getDistribution(bIndices);
        int sizeA = distA.length;
        int sizeB = distB.length;
        long[] prefixB = new long[sizeB];
        long sum = 0;

        for (int i = 0; i < sizeB; i++) {
            sum += distB[i];
            prefixB[i] = sum;
        }
        long wins = 0;

        for (int sA = 0; sA < sizeA; sA++) {
            if (distA[sA] == 0) {
                continue;
            }
            int idx = sA - 1;
            if (idx >= 0) {
                wins += distA[sA] * prefixB[idx];
            }
        }
        return wins;
    }
    
    long[] getDistribution(List<Integer> indices) {
        int diceCount = indices.size();
        int size = diceCount * 100 + 1;
        long[] dp = new long[size];
        dp[0] = 1;
        for (int idx : indices) {
            long[] ndp = new long[size];
            for (int s = 0; s < size; s++) {
                if (dp[s] == 0) {
                    continue;
                }
                for (int face : diceArr[idx]) {
                    if(s + face < size) {
                        ndp[s + face] += dp[s];
                    }
                }
            }
            dp = ndp;
        }
        return dp;
    }
}
