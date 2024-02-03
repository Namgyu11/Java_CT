package codingTest.CT.CT17.ct01;

import java.util.*;

//24-02-01 (풀이) 다시 풀기 (two 포인터)
public class Solution {

  public int solution1(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;

    return (nums[n - 1] - 1) * (nums[n - 2] - 1);
  }
  public int solution(int[] nums) {
    int max1 = 0, max2 = 0;

    for(int num : nums) {
      if(num > max1) {
        max2 = max1;
        max1 = num;
      } else if(num > max2) {
        max2 = num;
      }
    }

    return (max1 - 1) * (max2 - 1);
  }

}
