package codingTest.programmers.lv2.당구_연습;

import java.util.*;

class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] ans = new int[balls.length];
        for (int idx = 0; idx < balls.length; idx++) {
            int a = balls[idx][0], b = balls[idx][1];
            long best = Long.MAX_VALUE;

            if (!(startX == a && startY < b)) {
                long dx = startX - a;
                long dy = startY - (2L * n - b);
                best = Math.min(best, dx * dx + dy * dy);
            }
            if (!(startX == a && startY > b)) {
                long dx = startX - a;
                long dy = startY - (-b);
                best = Math.min(best, dx * dx + dy * dy);
            }
            if (!(startY == b && startX < a)) {
                long dx = startX - (2L * m - a);
                long dy = startY - b;
                best = Math.min(best, dx * dx + dy * dy);
            }
            if (!(startY == b && startX > a)) {
                long dx = startX - (-a);
                long dy = startY - b;
                best = Math.min(best, dx * dx + dy * dy);
            }

            ans[idx] = (int) best;
        }
        return ans;
    }
}
