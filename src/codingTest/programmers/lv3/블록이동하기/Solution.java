package codingTest.programmers.lv3.블록이동하기;

import java.util.*;

class Solution {
    static class State {
        int r, c, dir, dist;
        State(int r, int c, int dir, int dist) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.dist = dist;
        }
    }

    public int solution(int[][] board) {
        int n = board.length;
        boolean[][][] visited = new boolean[n][n][2];
        Queue<State> q = new LinkedList<>();
        visited[0][0][0] = true;
        q.offer(new State(0, 0, 0, 0));

        while (!q.isEmpty()) {
            State s = q.poll();
            int r = s.r, c = s.c, dir = s.dir, d = s.dist;
            if ((dir == 0 && r == n-1 && c+1 == n-1) ||
                (dir == 1 && r+1 == n-1 && c == n-1)) {
                return d;
            }
            int[] dr = {-1, 1, 0, 0};
            int[] dc = {0, 0, -1, 1};
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k], nc = c + dc[k];
                if (canMove(nr, nc, dir, board)) {
                    if (!visited[nr][nc][dir]) {
                        visited[nr][nc][dir] = true;
                        q.offer(new State(nr, nc, dir, d+1));
                    }
                }
            }
            
            if (dir == 0) { 
                if (r+1 < n && board[r+1][c] == 0 && board[r+1][c+1] == 0) {
                    if (!visited[r][c][1]) {
                        visited[r][c][1] = true;
                        q.offer(new State(r, c, 1, d+1));
                    }
                    if (!visited[r][c+1][1]) {
                        visited[r][c+1][1] = true;
                        q.offer(new State(r, c+1, 1, d+1));
                    }
                }
            } else { 
                if (c+1 < n && board[r][c+1] == 0 && board[r+1][c+1] == 0) {
                    if (!visited[r][c][0]) {
                        visited[r][c][0] = true;
                        q.offer(new State(r, c, 0, d+1));
                    }
                    if (!visited[r+1][c][0]) {
                        visited[r+1][c][0] = true;
                        q.offer(new State(r+1, c, 0, d+1));
                    }
                }
            }
        }
        return -1; 
    }

    private boolean canMove(int r, int c, int dir, int[][] board) {
        int n = board.length;
        if (r < 0 || c < 0 || r >= n || c >= n) {
            return false;
        }
        if (dir == 0) {
            if (c + 1 >= n) {
                return false;
            }
            return board[r][c] == 0 && board[r][c+1] == 0;
        } else {
            if (r + 1 >= n) {
                return false;
            }
            return board[r][c] == 0 && board[r+1][c] == 0;
        }
    }
}
