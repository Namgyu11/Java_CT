package codingTest.programmers.lv3.금과은운반하기;

import java.util.*;

class Solution {
    public long solution(long a, long b, int[] g, int[] s, int[] w, int[] t) {
        int n = g.length;
        long lo = 0, hi = (long)4e14;
        long ans = hi;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            long sumG = 0, sumS = 0, sumAll = 0;
            for (int i = 0; i < n; i++) {
                long roundTrips = mid / (2L * t[i]);
                long extra = (mid % (2L * t[i]) >= t[i]) ? 1 : 0;
                long cap = (roundTrips + extra) * w[i];
                sumG   += Math.min((long)g[i], cap);
                sumS   += Math.min((long)s[i], cap);
                sumAll += cap;
                if (sumG >= a && sumS >= b && sumAll >= a + b) {
                    break;
                }
            }
            if (sumG >= a && sumS >= b && sumAll >= a + b) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }
}
