package codingTest.CT.CT_FINAL.ct04;

public class Solution {
  private static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 오른쪽, 아래, 왼쪽, 위 순서

  public int solution(int[][] board) {
    int answer = 0;
    int x = 0, y = 0, dir = 0;
    int rows = board.length, cols = board[0].length;

    while (true) {
      if (board[x][y] == 0) {
        board[x][y] = -1;
        answer++;
      }

      boolean cleaned = false;
      for (int i = 0; i < 4; i++) {
        dir = (dir + 1) % 4;
        int nextX = x + directions[dir][0];
        int nextY = y + directions[dir][1];

        if (nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols && board[nextX][nextY] == 0) {
          x = nextX;
          y = nextY;
          cleaned = true;
          break;
        }
      }

      if (!cleaned) {
        break;
      }
    }

    return answer;
  }
}
