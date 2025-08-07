package codingTest.programmers.lv2.가장_많이_받은_선물;

import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        Map<String, Integer> idx = new HashMap<>();
        for (int i = 0; i < n; i++) {
            idx.put(friends[i], i);
        }
        int[][] giftsCnt = new int[n][n];
        for (String g : gifts) {
            String[] parts = g.split(" ");
            int a = idx.get(parts[0]);
            int b = idx.get(parts[1]);
            giftsCnt[a][b]++;
        }
        int[] giftIndex = new int[n];
        for (int i = 0; i < n; i++) {
            int given = 0, received = 0;
            for (int j = 0; j < n; j++) {
                given += giftsCnt[i][j];
                received += giftsCnt[j][i];
            }
            giftIndex[i] = given - received;
        }
        int[] receive = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int gij = giftsCnt[i][j];
                int gji = giftsCnt[j][i];
                if (gij != gji) {
                    if (gij > gji) {
                        receive[i]++;
                    } else {
                        receive[j]++;
                    }
                } else {
                    if (giftIndex[i] != giftIndex[j]) {
                        if (giftIndex[i] > giftIndex[j]) {
                            receive[i]++;
                        } else {
                            receive[j]++;
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int x : receive) {
            if (x > ans) {
                ans = x;
            }
        }
        return ans;
    }
}
