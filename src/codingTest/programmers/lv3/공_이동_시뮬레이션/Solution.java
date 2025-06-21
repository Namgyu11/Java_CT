package codingTest.programmers.lv3.공_이동_시뮬레이션;

class Solution {
    public long solution(long n, long m, int x, int y, int[][] queries) {
        long r1 = x, r2 = x, c1 = y, c2 = y;
        for (int i = queries.length - 1; i >= 0; i--) {
            int cmd = queries[i][0];
            long d = queries[i][1];
            if (cmd == 0) {
                long nc1 = c1 + d;
                long nc2 = c2 + d;
                if (c1 == 0) {
                    nc1 = 0;
                }
                c1 = Math.max(0, nc1);
                c2 = Math.min(m - 1, nc2);
            } else if (cmd == 1) {
                long nc1 = c1 - d;
                long nc2 = c2 - d;
                if (c2 == m - 1) {
                    nc2 = m - 1;
                }
                c1 = Math.max(0, nc1);
                c2 = Math.min(m - 1, nc2);
            } else if (cmd == 2) {
                long nr1 = r1 + d;
                long nr2 = r2 + d;
                if (r1 == 0) {
                    nr1 = 0;
                }
                r1 = Math.max(0, nr1);
                r2 = Math.min(n - 1, nr2);
            } else { 
                long nr1 = r1 - d;
                long nr2 = r2 - d;
                if (r2 == n - 1) {
                    nr2 = n - 1;
                }
                r1 = Math.max(0, nr1);
                r2 = Math.min(n - 1, nr2);
            }
            if (r1 > r2 || c1 > c2) {
                return 0;
            }
        }
        return (r2 - r1 + 1) * (c2 - c1 + 1);
    }
}
