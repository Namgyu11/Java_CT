package codingTest.programmers.lv2.지게차와크레인;

import java.util.*;

class Solution {
    public int solution(String[] storage, String[] requests) {
        int n = storage.length;
        int m = storage[0].length();
        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = storage[i].toCharArray();
        }
        
        for (String req : requests) {
            if (req.length() == 1) {
                char target = req.charAt(0);
                boolean[][] external = new boolean[n][m];
                Queue<int[]> queue = new LinkedList<>();
                for (int i = 0; i < n; i++) {
                    if (grid[i][0] == '.') {
                        external[i][0] = true;
                        queue.offer(new int[]{i, 0});
                    }
                    if (grid[i][m - 1] == '.') {
                        external[i][m - 1] = true;
                        queue.offer(new int[]{i, m - 1});
                    }
                }
                for (int j = 0; j < m; j++) {
                    if (grid[0][j] == '.') {
                        external[0][j] = true;
                        queue.offer(new int[]{0, j});
                    }
                    if (grid[n - 1][j] == '.') {
                        external[n - 1][j] = true;
                        queue.offer(new int[]{n - 1, j});
                    }
                }
                int[] dx = {1, -1, 0, 0};
                int[] dy = {0, 0, 1, -1};
                while (!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    int cx = cur[0], cy = cur[1];
                    for (int d = 0; d < 4; d++) {
                        int nx = cx + dx[d], ny = cy + dy[d];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                            continue;
                        }
                        if (grid[nx][ny] == '.' && !external[nx][ny]) {
                            external[nx][ny] = true;
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                }
                
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (grid[i][j] == target) {
                            if (isAccessible(grid, external, i, j, n, m)) {
                                grid[i][j] = '.';
                            }
                        }
                    }
                }
            } else {
                char target = req.charAt(0);
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (grid[i][j] == target) {
                            grid[i][j] = '.';
                        }
                    }
                }
            }
        }
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != '.') {
                    count++;
                }
            }
        }
        return count;
    }
    
    private boolean isAccessible(char[][] grid, boolean[][] external, int x, int y, int n, int m) {
        if (x == 0 || x == n - 1 || y == 0 || y == m - 1) {
            return true;
        }
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d], ny = y + dy[d];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && external[nx][ny]) {
                return true;
            }
        }
        return false;
    }
}