package codingTest.preCT_02.preCT_04.ct03.ct04;

public class Solution {
    public static int solution(int[] nums) {
        int count = 0;
        for (int i = 0; i <nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] == nums[j]){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2,5,6,3,2,6,6};
        System.out.println(solution(nums));
    }
}
