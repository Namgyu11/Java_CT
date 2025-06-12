package codingTest.programmers.lv3.보행자_천국;

class Solution {
    static final int MOD = 20170805;
    public int solution(int m, int n, int[][] city_map) {
        int[][] h = new int[m][n];
        int[][] v = new int[m][n];
        h[0][0] = 1;
        v[0][0] = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (city_map[i][j] == 1) {
                    h[i][j] = v[i][j] = 0;
                } else {
                    if (j > 0 && city_map[i][j-1] != 1) {
                        if (city_map[i][j-1] == 2) {
                            h[i][j] = h[i][j-1];
                        } else {
                            h[i][j] = (h[i][j-1] + v[i][j-1]) % MOD;
                        }
                    }
                    if (i > 0 && city_map[i-1][j] != 1) {
                        if (city_map[i-1][j] == 2) {
                            v[i][j] = v[i-1][j];
                        } else {
                            v[i][j] = (h[i-1][j] + v[i-1][j]) % MOD;
                        }
                    }
                }
            }
        }
        return (h[m-1][n-1] + v[m-1][n-1]) % MOD;
    }
}
