package codingTest.programmers.lv3.기지국설치;

class Solution {
    public int solution(int N, int[] stations, int W) {
        long coverLen = 2L * W + 1;
        long ans = 0;
        long coveredEnd = 0;

        for (int s : stations) {
            long start = (long)s - W;
            long gap = start - (coveredEnd + 1);
            if (gap > 0) {
                ans += (gap + coverLen - 1) / coverLen;
            }
            coveredEnd = (long)s + W;
        }
        if (coveredEnd < N) {
            long gap = N - coveredEnd;
            ans += (gap + coverLen - 1) / coverLen;
        }
        return (int)ans;
    }
}
