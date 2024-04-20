package codingTest.CT.CT_FINAL.ct05;
import java.util.*;

//24-03-23 다시 풀기 --
public class Solution {

  public int[] solution(int[] nums) {
    HashMap<Integer, Integer> counts = new HashMap<>();
    for (int num : nums) {
      counts.put(num, counts.getOrDefault(num, 0) + 1);
    }

    Arrays.sort(nums);
    int n = nums.length / 2;
    int[] answer = new int[n];
    int idx = 0;

    for (int num : nums) {
      if (num % 2 == 0 && counts.getOrDefault(num / 2, 0) > 0) {
        counts.put(num, counts.get(num) - 1);
        counts.put(num / 2, counts.get(num / 2) - 1);
        answer[idx++] = num / 2;
      }
    }

    if (idx != n) {
      return new int[0];
    }

    return answer;
  }
}
