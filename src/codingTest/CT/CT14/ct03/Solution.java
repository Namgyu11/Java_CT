package codingTest.CT.CT14.ct03;

import java.util.*;
//24-01-11 풀이 - 다시 풀기

class Solution {
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    private static final int DAY = 0;
    private static final int NIGHT = 1;

    public int solution(int[][] maze) {
        int n = maze.length;
        int m = maze[0].length;
        boolean[][][] visited = new boolean[n][m][2];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0, DAY});
        visited[0][0][DAY] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int count = cur[2];
            int time = cur[3];

            if (x == n - 1 && y == m - 1) {
                return count;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nextTime = count % 5 == 4 ? (time == DAY ? NIGHT : DAY) : time;

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny][nextTime]) {
                    if (maze[nx][ny] != 1 && (nextTime == DAY || maze[nx][ny] != 2)) {
                        queue.add(new int[]{nx, ny, count + 1, nextTime});
                        visited[nx][ny][nextTime] = true;
                    }
                }
            }
        }

        return -1;
    }
}
