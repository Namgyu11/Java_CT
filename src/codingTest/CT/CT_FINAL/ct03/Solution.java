package codingTest.CT.CT_FINAL.ct03;

//24-03-23 다시 풀기
public class Solution {
  public int[] solution(int[] nums) {
    boolean unstable = true;

    while (unstable) {
      unstable = false;
      int[] newNums = nums.clone();

      for (int i = 1; i < nums.length - 1; i++) {
        if (nums[i] < nums[i - 1] && nums[i] < nums[i + 1]) {
          newNums[i]++;
          unstable = true;
        } else if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
          newNums[i]--;
          unstable = true;
        }
      }

      nums = newNums;
    }

    return nums;
  }

}
