package codingTest.CT.CT09.ct02;

import java.util.*;


//23-12-08(풇이) - 다시 풀기 - BFS
public class Solution {
    public int solution(int N, int[][] flight, int a, int b, int k) {
        int[][] dp = new int[N][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dp[a][0] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{a, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentNode = current[0];
            int currentK = current[1];

            for (int[] f : flight) {
                if (f[0] == currentNode && currentK < k) {
                    int nextNode = f[1];
                    int nextK = currentK + 1;
                    int nextCost = dp[currentNode][currentK] + f[2];

                    if (nextCost < dp[nextNode][nextK]) {
                        dp[nextNode][nextK] = nextCost;
                        queue.offer(new int[]{nextNode, nextK});
                    }
                }
            }
        }

        int answer = Arrays.stream(dp[b]).min().getAsInt();
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
