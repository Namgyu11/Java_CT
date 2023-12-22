package codingTest.CT.CT11.ct05;
//23-12-22(풀이) - 다시 풀기 -BFS 너비 우선 탐색

import java.util.*;

class Solution {
    int[] dx = {1, 0, -1, 0}; // 상,하,좌,우
    int[] dy = {0, 1, 0, -1};

    class Position {
        int x, y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solution(int N, int M, int[][] maze) {
        boolean[][] visited = new boolean[N][M];
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(0, 0));
        visited[0][0] = true;

        int moveCount = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Position pos = queue.poll();
                if (pos.x == N - 1 && pos.y == M - 1) return moveCount;
                for (int j = 0; j < 4; j++) {
                    int nx = pos.x + dx[j];
                    int ny = pos.y + dy[j];
                    if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                        if (maze[nx][ny] == 0 && !visited[nx][ny]) {
                            queue.offer(new Position(nx, ny));
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
            moveCount++;
        }

        return -1;
    }
}
