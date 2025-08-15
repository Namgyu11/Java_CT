package codingTest.programmers.lv2.컬러링북;

import java.util.*;

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        boolean[][] visited = new boolean[m][n];
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (picture[r][c] == 0 || visited[r][c]) {
                    continue;
                }

                numberOfArea++;
                int color = picture[r][c];
                int size = 0;

                ArrayDeque<int[]> q = new ArrayDeque<>();
                q.offer(new int[]{r, c});
                visited[r][c] = true;

                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    size++;

                    for (int k = 0; k < 4; k++) {
                        int nr = cur[0] + dr[k];
                        int nc = cur[1] + dc[k];

                        if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                            continue;
                        }
                        if (visited[nr][nc]) {
                            continue;
                        }
                        if (picture[nr][nc] != color) {
                            continue;
                        }

                        visited[nr][nc] = true;
                        q.offer(new int[]{nr, nc});
                    }
                }

                if (size > maxSizeOfOneArea) {
                    maxSizeOfOneArea = size;
                }
            }
        }

        return new int[]{numberOfArea, maxSizeOfOneArea};
    }
}