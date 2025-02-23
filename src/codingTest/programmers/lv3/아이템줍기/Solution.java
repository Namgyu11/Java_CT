package codingTest.programmers.lv3.아이템줍기;

import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int boardSize = 102;
        int[][] board = new int[boardSize][boardSize];

        for (int i = 0; i < rectangle.length; i++) {
            int x1 = rectangle[i][0] * 2;
            int y1 = rectangle[i][1] * 2;
            int x2 = rectangle[i][2] * 2;
            int y2 = rectangle[i][3] * 2;
            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    board[x][y] = 1;
                }
            }
        }
        
        for (int i = 0; i < rectangle.length; i++) {
            int x1 = rectangle[i][0] * 2;
            int y1 = rectangle[i][1] * 2;
            int x2 = rectangle[i][2] * 2;
            int y2 = rectangle[i][3] * 2;
            for (int x = x1 + 1; x < x2; x++) {
                for (int y = y1 + 1; y < y2; y++) {
                    board[x][y] = 0;
                }
            }
        }
        
        int startX = characterX * 2;
        int startY = characterY * 2;
        int endX = itemX * 2;
        int endY = itemY * 2;
        
        int[][] dist = new int[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            Arrays.fill(dist[i], -1);
        }
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startX, startY});
        dist[startX][startY] = 0;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0], cy = cur[1];
            if (cx == endX && cy == endY) {
                break;
            }
            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d], ny = cy + dy[d];
                if (nx < 0 || nx >= boardSize || ny < 0 || ny >= boardSize) {
                    continue;
                }
                if (board[nx][ny] == 0) {
                    continue;
                }
                if (dist[nx][ny] != -1) {
                    continue;
                }
                dist[nx][ny] = dist[cx][cy] + 1;
                q.offer(new int[]{nx, ny});
            }
        }
        return dist[endX][endY] / 2;
    }
}