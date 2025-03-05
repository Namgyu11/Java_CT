package codingTest.programmers.lv3.파괴되지않은건물;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int n = board.length;
        int m = board[0].length;
        int[][] diff = new int[n + 1][m + 1];
        
        for (int[] s : skill) {
            int type = s[0];
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int degree = s[5];
            int effect = (type == 1) ? -degree : degree;
            
            diff[r1][c1] += effect;
            if (c2 + 1 < m + 1) {
                diff[r1][c2 + 1] -= effect;
            }
            if (r2 + 1 < n + 1) {
                diff[r2 + 1][c1] -= effect;
            }
            if (r2 + 1 < n + 1 && c2 + 1 < m + 1) {
                diff[r2 + 1][c2 + 1] += effect;
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                diff[i][j] += diff[i][j - 1];
            }
        }
        
        for (int j = 0; j < m; j++) {
            for (int i = 1; i < n; i++) {
                diff[i][j] += diff[i - 1][j];
            }
        }
        
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int finalDurability = board[i][j] + diff[i][j];
                if (finalDurability >= 1) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
