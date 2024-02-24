package codingTest.CT.CT20.ct02;

public class Solution {

  public int solution(int[][] x, int[][] y) {
    int answer = 0;
    for (int i = 0; i < x.length; i++) {
      for (int j = 0; j < y.length; j++) {
        if (x[i][0] == y[j][0]) {
          answer += x[i][1] * y[j][1];
        }
      }
    }
    return answer;
  }
}


