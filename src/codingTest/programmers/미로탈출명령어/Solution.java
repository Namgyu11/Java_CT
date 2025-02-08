package codingTest.programmers.미로탈출명령어;


public class Solution {
    private int n, m, r, c, k;
    private String answer = "impossible";
    private final int[] dx = {1, 0, 0, -1};
    private final int[] dy = {0, -1, 1, 0};
    private final char[] dir = {'d', 'l', 'r', 'u'};

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        this.n = n;
        this.m = m;
        this.r = r;
        this.c = c;
        this.k = k;

        int minDist = Math.abs(x - r) + Math.abs(y - c);
        if (minDist > k || (k - minDist) % 2 != 0) return "impossible";

        dfs(x, y, new StringBuilder(), 0);
        return answer;
    }

    private boolean dfs(int x, int y, StringBuilder path, int depth) {
        if (!answer.equals("impossible")) return true;

        if (depth == k) {
            if (x == r && y == c) answer = path.toString();
            return x == r && y == c;
        }

        int remaining = k - depth;
        int dist = Math.abs(x - r) + Math.abs(y - c);
        if (dist > remaining) return false;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 1 && ny >= 1 && nx <= n && ny <= m) {
                path.append(dir[i]);
                if (dfs(nx, ny, path, depth + 1)) return true;
                path.deleteCharAt(path.length() - 1);
            }
        }
        return false;
    }
}
