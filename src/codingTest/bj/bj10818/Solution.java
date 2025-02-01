package codingTest.bj.bj10818;

public class Solution {
  public boolean exist(char[][] board, String word) {
    for(int i = 0; i < board.length; i++) {
      for(int j = 0; j < board[i].length; j++) {
        if(board[i][j] == word.charAt(0) && dfs(board, i, j, 0, word)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean dfs(char[][] board, int i, int j, int count, String word) {
    if(count == word.length()) {
      return true;
    }

    if(i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != word.charAt(count)) {
      return false;
    }

    char temp = board[i][j];
    board[i][j] = ' '; // 사용한 셀을 표시
    boolean found = dfs(board, i + 1, j, count + 1, word)
        || dfs(board, i - 1, j, count + 1, word)
        || dfs(board, i, j + 1, count + 1, word)
        || dfs(board, i, j - 1, count + 1, word);

    board[i][j] = temp; // 백트래킹, 셀을 원래 상태로 복구
    return found;
  }
}
