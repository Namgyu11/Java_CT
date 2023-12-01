package codingTest.CT.CT08.ct04;

// 23-12-01 (풀이) - 다시 풀어 보기 (dp)
public class Solution {
    final int MOD = 1007;
    int[][][] dp;
    int[][] maze;
    int N, M;

    public int solution(int[][] maze) {
        this.maze = maze;
        N = maze.length;
        M = maze[0].length;
        dp = new int[N][M][2];
        for (int[][] a : dp)
            for (int[] b : a)
                b[0] = b[1] = -1;
        return dfs(0, 0, 0);
    }

    int dfs(int x, int y, int key) {
        if (x == N - 1 && y == M - 1) return 1;
        if (dp[x][y][key] != -1) return dp[x][y][key];

        dp[x][y][key] = 0;
        int[] dx = {0, 1};
        int[] dy = {1, 0};
        for (int dir = 0; dir < 2; dir++) {
            int nx = x + dx[dir], ny = y + dy[dir];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (maze[nx][ny] == 1) continue;
            if (maze[nx][ny] == 2) dp[x][y][key] = (dp[x][y][key] + dfs(nx, ny, 1)) % MOD;
            else dp[x][y][key] = (dp[x][y][key] + dfs(nx, ny, key)) % MOD;
        }
        return dp[x][y][key];
    }
}
