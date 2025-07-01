package codingTest.preCT_03.preCT_03_01.표현가능한이진트리.경주로_건설;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    static class State implements Comparable<State> {
        int x, y, dir, cost;
        State(int x, int y, int dir, int cost) {
            this.x = x; this.y = y; this.dir = dir; this.cost = cost;
        }
        public int compareTo(State o) {
            return this.cost - o.cost;
        }
    }
    
    public int solution(int[][] board) {
        int n = board.length;
       
        int[] dx = {-1, 0, 1,  0};
        int[] dy = { 0, 1, 0, -1};
       
        int[][][] dist = new int[n][n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }
        
        PriorityQueue<State> pq = new PriorityQueue<>();
       
        if (board[0][1] == 0) {
            dist[0][1][1] = 100;
            pq.offer(new State(0, 1, 1, 100));
        }
        if (board[1][0] == 0) {
            dist[1][0][2] = 100;
            pq.offer(new State(1, 0, 2, 100));
        }
        
        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int x = cur.x, y = cur.y, dir = cur.dir, cost = cur.cost;
            if (cost > dist[x][y][dir]) {
                continue;
            }
            if (x == n - 1 && y == n - 1) {
                continue;
            }
            for (int nd = 0; nd < 4; nd++) {
                int nx = x + dx[nd], ny = y + dy[nd];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }
                if (board[nx][ny] == 1) {
                    continue;
                }
                int ncost = cost + 100 + (nd == dir ? 0 : 500);
                if (ncost < dist[nx][ny][nd]) {
                    dist[nx][ny][nd] = ncost;
                    pq.offer(new State(nx, ny, nd, ncost));
                }
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for (int d = 0; d < 4; d++) {
            ans = Math.min(ans, dist[n - 1][n - 1][d]);
        }
        return ans;
    }
}
