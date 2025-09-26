package ktb_ct.week01.ct02.지형_편집;

import java.util.Arrays;

class Solution {
    public long solution(int[][] land, int P, int Q) {
        int N = land.length;
        int M = land[0].length;
        int total = N * M;
        int[] heights = new int[total];
        int idx = 0;
        int minH = Integer.MAX_VALUE, maxH = Integer.MIN_VALUE;
        for (int[] row : land) {
            for (int h : row) {
                heights[idx++] = h;
                if (h < minH) {
                    minH = h;
                }
                if (h > maxH) {
                    maxH = h;
                }
            }
        }
        Arrays.sort(heights);
        
        long low = minH, high = maxH;
        while (low < high) {
            long mid = (low + high) / 2;
            int less = lowerBound(heights, (int)mid) ;
            int greater = total - upperBound(heights, (int)mid);
            long slope = (long)P * less - (long)Q * greater;
            if (slope < 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        long best = Long.MAX_VALUE;
        for (long h = low - 1; h <= low + 1; h++) {
            if (h < minH || h > maxH) {
                continue;
            }
            long addCost = 0, remCost = 0;
            for (int a : heights) {
                if (a < h) {
                    addCost += (h - a);
                } else if (a > h) {
                    remCost += (a - h);
                }
            }
            long cost = addCost * P + remCost * Q;
            if (cost < best) {
                best = cost;
            }
        }
        return best;
    }
    
    private int lowerBound(int[] A, int key) {
        int l = 0, r = A.length;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (A[m] < key) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
    
    private int upperBound(int[] A, int key) {
        int l = 0, r = A.length;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (A[m] <= key) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}
