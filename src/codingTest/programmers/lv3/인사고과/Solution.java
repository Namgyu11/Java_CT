package codingTest.programmers.lv3.인사고과;

import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int[] wanho = scores[0];

        Arrays.sort(scores, (s1, s2) -> s1[0] == s2[0] ? s1[1] - s2[1] : s2[0] - s1[0]);

        int maxB = 0;
        List<int[]> validScores = new ArrayList<>();

        for (int[] score : scores) {
            if (score[1] < maxB) {
                if (Arrays.equals(score, wanho)) {
                    return -1;
                }
            } else {
                maxB = Math.max(maxB, score[1]);
                validScores.add(score);
            }
        }

        validScores.sort((s1, s2) -> (s2[0] + s2[1]) - (s1[0] + s1[1]));

        int rank = 1, prevSum = -1, count = 0;
        for (int[] score : validScores) {
            int sum = score[0] + score[1];

            if (prevSum != sum) {
                rank += count;
            }
            count = (sum == prevSum) ? count + 1 : 1;
            prevSum = sum;

            if (Arrays.equals(score, wanho)) {
                return rank;
            }
        }

        return -1;
    }
}
