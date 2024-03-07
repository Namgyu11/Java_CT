package codingTest.CT.CT21.ct04;
import java.util.*;

public class Solution {
  int m, n;
  int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
  int[][] boardCopy;
  boolean[][] visited;

  public int[][] solution(int[][] board) {
    m = board.length;
    n = board[0].length;
    boardCopy = new int[m][n];
    visited = new boolean[m][n];

    while (true) {
      boolean isRemoved = false;
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (board[i][j] != 0) {
            copyBoard(board);
            if (dfs(i, j, board[i][j]) >= 3) {
              isRemoved = true;
              removeBlocks(i, j, board[i][j]);
              fallBlocks(board);
            }
          }
        }
      }
      if (!isRemoved) break;
    }

    return board;
  }

  public int dfs(int x, int y, int value) {
    int count = 1;
    visited[x][y] = true;

    for (int[] dir : direction) {
      int nx = x + dir[0];
      int ny = y + dir[1];

      if (nx >= 0 && nx < m && ny >= 0 && ny < n && boardCopy[nx][ny] == value && !visited[nx][ny]) {
        count += dfs(nx, ny, value);
      }
    }

    return count;
  }

  public void removeBlocks(int x, int y, int value) {
    boardCopy[x][y] = 0;

    for (int[] dir : direction) {
      int nx = x + dir[0];
      int ny = y + dir[1];

      if (nx >= 0 && nx < m && ny >= 0 && ny < n && boardCopy[nx][ny] == value) {
        removeBlocks(nx, ny, value);
      }
    }
  }

  public void copyBoard(int[][] board) {
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        boardCopy[i][j] = board[i][j];
        visited[i][j] = false;
      }
    }
  }

  public void fallBlocks(int[][] board) {
    for (int j = 0; j < n; j++) {
      LinkedList<Integer> list = new LinkedList<>();
      for (int i = m - 1; i >= 0; i--) {
        if (boardCopy[i][j] != 0) list.add(boardCopy[i][j]);
        board[i][j] = 0;
      }
      int idx = m - 1;
      while (!list.isEmpty()) {
        board[idx--][j] = list.pollFirst();
      }
    }
  }
}
