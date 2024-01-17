package codingTest.CT.CT_month_04.ct03;
import java.util.*;


//24-01-14(풀이) - 다시 풀기 - 다익스트라 알고리즘
public class Solution {

    public int solution(int N, int[][] arr) {
        int[][] dp = new int[N][N];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for(int[] row : dp)
            Arrays.fill(row, Integer.MAX_VALUE);

        dp[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.offer(new int[]{0, 0, 0});

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0], y = cur[1], cost = cur[2];

            if(cost > dp[x][y]) continue;

            for(int i=0; i<4; i++) {
                int nx = x + dx[i], ny = y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                int nextCost = cost + Math.abs(arr[nx][ny] - arr[x][y]);

                if(nextCost < dp[nx][ny]) {
                    dp[nx][ny] = nextCost;
                    pq.offer(new int[]{nx, ny, nextCost});
                }
            }
        }
        return dp[N-1][N-1];
    }
}
