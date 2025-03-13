package codingTest.programmers.lv2.서버증설횟수;

import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int[] servers = new int[24];
        int expansionCount = 0;
        for (int i = 0; i < 24; i++) {
            int requiredServers = (players[i] < m) ? 0 : (players[i] / m);
            int activeServers = 0;
            for (int j = Math.max(0, i - k + 1); j <= i; j++) {
                activeServers += servers[j];
            }
            int additionalServers = requiredServers - activeServers;
            if (additionalServers > 0) {
                servers[i] += additionalServers;
                expansionCount += additionalServers;
            }
        }
        return expansionCount;
    }
}
