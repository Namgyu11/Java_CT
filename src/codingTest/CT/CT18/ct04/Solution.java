package codingTest.CT.CT18.ct04;


//24-02-09 (풀이) 다시 풀기 -- 브루트 포스
public class Solution {

  public int solution(int[] x, int[] y, int k) {
    int n = x.length;
    int max = Integer.MIN_VALUE;

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n && x[j] - x[i] <= k; j++) {
        max = Math.max(max, y[i] + y[j] + x[j] - x[i]);
      }
    }
    return max;
  }

}
