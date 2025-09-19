package ktb_ct.week02.ct02.지형_이동;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    static class Node {
        int x, y, cost;
        Node(int x, int y, int cost) { this.x = x; this.y = y; this.cost = cost; }
    }

    public int solution(int[][] land, int height) {
        int n = land.length;
        boolean[][] vis = new boolean[n][n];
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        pq.add(new Node(0, 0, 0));

        long ans = 0;
        int visited = 0;
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        while (visited < n * n) {
            Node cur = pq.poll();
            if (vis[cur.x][cur.y]) {
                continue;
            }
            vis[cur.x][cur.y] = true;
            ans += cur.cost;
            visited++;

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d], ny = cur.y + dy[d];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }
                if (vis[nx][ny]) {
                    continue;
                }
                int diff = Math.abs(land[nx][ny] - land[cur.x][cur.y]);
                int w = diff <= height ? 0 : diff;
                pq.add(new Node(nx, ny, w));
            }
        }
        return (int) ans;
    }
}
