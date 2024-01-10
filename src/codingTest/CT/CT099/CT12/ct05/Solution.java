package codingTest.CT.CT099.CT12.ct05;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int solution(int N, int M, int[][] maze) {
        boolean[][][] visited = new boolean[N][M][2];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0});
        visited[0][0][0] = true;
        int step = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1], bomb = cur[2];
                if (x == N - 1 && y == M - 1) {
                    return step;
                }
                for (int[] dir : dirs) {
                    int nx = x + dir[0], ny = y + dir[1];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                    if (bomb == 1 && maze[nx][ny] == 1) continue;
                    if (maze[nx][ny] == 1 && bomb == 0 && !visited[nx][ny][bomb + 1]) {
                        visited[nx][ny][bomb + 1] = true;
                        queue.offer(new int[]{nx, ny, bomb + 1});
                    } else if (maze[nx][ny] == 0 && !visited[nx][ny][bomb]) {
                        visited[nx][ny][bomb] = true;
                        queue.offer(new int[]{nx, ny, bomb});
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
