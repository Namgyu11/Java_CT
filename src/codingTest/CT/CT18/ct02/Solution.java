package codingTest.CT.CT18.ct02;

import java.util.*;

//24-02-09 (풀이) 다시 풀기 -- DP

public class Solution {

  public int solution(int n) {
    int[] uglyNumbers = new int[n];
    uglyNumbers[0] = 1;
    int index2 = 0, index3 = 0, index5 = 0;
    int factor2 = 2, factor3 = 3, factor5 = 5;
    for (int i = 1; i < n; i++) {
      int min = Math.min(Math.min(factor2, factor3), factor5);
      uglyNumbers[i] = min;
      if (factor2 == min) {
        factor2 = 2 * uglyNumbers[++index2];
      }
      if (factor3 == min) {
        factor3 = 3 * uglyNumbers[++index3];
      }
      if (factor5 == min) {
        factor5 = 5 * uglyNumbers[++index5];
      }
    }
    return uglyNumbers[n - 1];
  }

}
