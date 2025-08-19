package codingTest.programmers.lv2.유사_칸토어_비트열;

class Solution {
    long[] pow5 = new long[21];
    long[] ones = new long[21];

    public int solution(int n, long l, long r) {
        pow5[0] = 1;
        ones[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow5[i] = pow5[i - 1] * 5L;
            ones[i] = ones[i - 1] * 4L;
        }
        long ans = count(n, r) - count(n, l - 1);
        return (int) ans;
    }

    private long count(int n, long k) {
        if (k <= 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        long block = pow5[n - 1];
        int full = (int) (k / block);
        long rem = k % block;
        long res = prefixFullBlocks(n, full);
        if (full < 5 && full != 2) {
            res += count(n - 1, rem);
        }
        return res;
    }

    private long prefixFullBlocks(int n, int t) {
        int[] pref = {0, 1, 2, 2, 3, 4};
        return pref[t] * ones[n - 1];
    }
}
