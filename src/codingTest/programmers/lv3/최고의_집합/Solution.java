package codingTest.programmers.lv3.최고의_집합;

import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        if (s < n) {
            return new int[]{-1};
        }
        int base = s / n;
        int rem  = s % n;
        int[] ans = new int[n];
        for (int i = 0; i < n - rem; i++) {
            ans[i] = base;
        }
        for (int i = n - rem; i < n; i++) {
            ans[i] = base + 1;
        }
        return ans;
    }
}
