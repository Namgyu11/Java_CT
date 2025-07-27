package codingTest.preCT_03.preCT_03_01.lv4.징검다리;

import java.util.Arrays;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int[] points = new int[rocks.length + 2];
        points[0] = 0;
        System.arraycopy(rocks, 0, points, 1, rocks.length);
        points[points.length - 1] = distance;
        Arrays.sort(points);
        
        int low = 1, high = distance, ans = 0;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            int removed = 0;
            int last = points[0];
            
            for (int i = 1; i < points.length; i++) {
                if (points[i] - last < mid) {
                    removed++;
                } else {
                    last = points[i];
                }
            }
            
            if (removed <= n) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return ans;
    }
}
