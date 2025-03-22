package codingTest.programmers.lv2.비밀코드해독;

class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        return dfs(1, new int[5], 0, n, q, ans);
    }

    private int dfs(int start, int[] comb, int idx, int n, int[][] q, int[] ans) {
        if(idx == 5) {
            for (int i = 0; i < q.length; i++) {
                int cnt = 0;
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 5; k++) {
                        if(comb[k] == q[i][j]) {
                            cnt++;
                            break;
                        }
                    }
                }
                if (cnt != ans[i]) {
                    return 0;
                }
            }
            return 1;
        }
        int count = 0;
        for (int i = start; i <= n - (5 - idx) + 1; i++) {
            comb[idx] = i;
            count += dfs(i + 1, comb, idx + 1, n, q, ans);
        }
        return count;
    }
}
