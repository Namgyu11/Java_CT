package ktb_ct.week02.ct03.이차원_동전_뒤집기;

class Solution {
    public int solution(int[][] beginning, int[][] target) {
        int m = beginning.length;
        int n = beginning[0].length;
        int[][] diff = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                diff[i][j] = beginning[i][j] ^ target[i][j];
            }
        }
        int[] r = new int[m];
        int[] c = new int[n];
        for (int j = 0; j < n; j++) {
            c[j] = diff[0][j]; 
        }
        for (int i = 0; i < m; i++) {
            r[i] = diff[i][0] ^ c[0];
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((r[i] ^ c[j]) != diff[i][j]) {
                    return -1;
                }
            }
        }
        int sumR = 0, sumC = 0;
        for (int x : r) {
            sumR += x;
        }
        for (int x : c) {
            sumC += x;
        }
        int F0 = sumR + sumC;
        int F1 = (m - sumR) + (n - sumC);
        return Math.min(F0, F1);
    }
}
