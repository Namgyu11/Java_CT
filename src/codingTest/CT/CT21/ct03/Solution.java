package codingTest.CT.CT21.ct03;

public class Solution {

  public int solution(int[][] trans) {
    int n = 0;
    for (int[] t : trans) {
      n = Math.max(n, Math.max(t[0], t[1]) + 1);
    }

    int[] balance = new int[n];
    for (int[] t : trans) {
      balance[t[0]] -= t[2];
      balance[t[1]] += t[2];
    }

    int answer = 0;
    for (int i = 0; i < n; i++) {
      if (balance[i] > 0) {
        answer++;
      }
    }

    return answer;
  }
}
