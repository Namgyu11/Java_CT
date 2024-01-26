package codingTest.CT.CT16.ct05;
import java.util.*;

public class Solution {

  int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

  public int solution(int[][] heights) {
    int m = heights.length;
    int n = heights[0].length;
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
    boolean[][] visited = new boolean[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
          pq.offer(new int[]{i, j, heights[i][j]});
          visited[i][j] = true;
        }
      }
    }

    int volume = 0;
    while (!pq.isEmpty()) {
      int[] cell = pq.poll();
      int x = cell[0], y = cell[1], h = cell[2];

      for (int[] dir : dirs) {
        int newX = x + dir[0], newY = y + dir[1];
        if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY]) {
          volume += Math.max(0, h - heights[newX][newY]);
          pq.offer(new int[]{newX, newY, Math.max(h, heights[newX][newY])});
          visited[newX][newY] = true;
        }
      }
    }

    return volume;
  }
}
