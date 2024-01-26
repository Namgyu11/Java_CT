package codingTest.CT.CT16.ct03;
import java.util.*;

//24-01-26(풀이) - 다시 풀기 - 탐색
public class Solution {

  public int solution(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    int maxSum = -1;
    for (int num : nums) {
      int sum = getSum(num);
      if (map.containsKey(sum)) {
        maxSum = Math.max(maxSum, num + map.get(sum));
        map.put(sum, Math.max(num, map.get(sum)));
      } else {
        map.put(sum, num);
      }
    }
    return maxSum;
  }

  private int getSum(int num) {
    int sum = 0;
    while (num != 0) {
      sum += num % 10;
      num /= 10;
    }
    return sum;
  }

}
