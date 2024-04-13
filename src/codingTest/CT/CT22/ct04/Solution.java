package codingTest.CT.CT22.ct04;

// 24-03-07 (풀이) 다시 풀기 -- 유클리드
public class Solution {

  public boolean solution(int x, int y, int target) {
    return target % gcd(x, y) == 0;
  }

  private int gcd(int a, int b) {
    while (b != 0) {
      int temp = a % b;
      a = b;
      b = temp;
    }
    return a;
  }
}
