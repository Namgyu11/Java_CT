package codingTest.CT.CT16.ct04;
import java.util.*;
//24-01-26(풀이) - 다시 풀기 - 다익스트라

public class Solution {

  int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

  public int solution(int[][] heights) {
    int m = heights.length;
    int n = heights[0].length;
    int[][] maxEfforts = new int[m][n];
    for (int[] row : maxEfforts) {
      Arrays.fill(row, Integer.MAX_VALUE);
    }
    maxEfforts[0][0] = 0;

    PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
    minHeap.offer(new int[]{0, 0, 0});

    while (!minHeap.isEmpty()) {
      int[] current = minHeap.poll();
      int x = current[0], y = current[1], maxEffort = current[2];

      if (x == m - 1 && y == n - 1) {
        return maxEffort;
      }

      for (int[] dir : dirs) {
        int newX = x + dir[0], newY = y + dir[1];
        if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
          int newEffort = Math.max(maxEffort, Math.abs(heights[newX][newY] - heights[x][y]));
          if (newEffort < maxEfforts[newX][newY]) {
            maxEfforts[newX][newY] = newEffort;
            minHeap.offer(new int[]{newX, newY, newEffort});
          }
        }
      }
    }
    return 0;
  }
}
