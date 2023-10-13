package codingTest.CT.CT01.ct05;

public class Solution {
    public long solution(int N, int M, int K, int[] capacity) {
        long answer = 1;
        long[] fac = new long[N + 1];
        fac[0] = 1;
        for (int i = 1; i <= N; i++) {
            fac[i] = fac[i - 1] * i;
        }

        for (int cap : capacity) {
            if (N < cap) continue;
            answer *= comb(N, cap, fac);
            N -= cap;
        }

        answer *= perm(K, M);

        return answer;
    }

    private long comb(int n, int r, long[] fac) {
        return fac[n] / (fac[r] * fac[n - r]);
    }

    private long perm(int n, int r) {
        if (r == 0) {
            return 1L;
        } else {
            return n * perm(n - 1, r - 1);
        }
    }
}
