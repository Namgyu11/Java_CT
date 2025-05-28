package codingTest.programmers.lv3.스티커모으기2;

class Solution {
    public int solution(int[] sticker) {
        int n = sticker.length;
        if (n == 1) {
            return sticker[0];
        }
        int[] dp1 = new int[n];
        dp1[1] = sticker[1];
        for (int i = 2; i < n; i++) {
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + sticker[i]);
        }
        int case1 = dp1[n-1];

        int[] dp2 = new int[n];
        dp2[0] = sticker[0];
        dp2[1] = Math.max(sticker[0], sticker[1]);
        for (int i = 2; i < n-1; i++) {
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + sticker[i]);
        }
        int case2 = dp2[n-2];
        return Math.max(case1, case2);
    }
}
