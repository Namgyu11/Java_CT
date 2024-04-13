package codingTest.CT.CT22.ct03;

//24-03-07 (풀이) 다시 풀기 -- 행렬의 곱셈
public class Solution {
  public int[][] solution(int[][] s, int[][] t) {
    int m = s.length;
    int n = s[0].length;
    int l = t[0].length;
    int[][] answer = new int[m][l];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (s[i][j] != 0) {
          for (int k = 0; k < l; k++) {
            answer[i][k] += s[i][j] * t[j][k];
          }
        }
      }
    }

    return answer;
  }
}
