package codingTest.CT.CT22.ct01;

import java.util.*;

// 24-03-07 (풀이) 다시 풀기 -- DP
public class Solution {
  public int solution(int[] nums) {

    Set<Integer> set = new LinkedHashSet<>();
    for(int n : nums) {
      set.add(n);
    }

    System.out.println(set);
    return set.size();
  }

  public static void main(String[] args) {
    Solution main = new Solution();
    System.out.println(main.solution(new int[]{6, 2, 4, 6, 11, 9, 9, 10}));
  }
}
