package codingTest.preCT_00.ct09.ct09_02;

public class Solution {
    public static int solution(int[] nums, int n) {
        int answer = -1;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == n){
                if(answer > i || answer == -1){
                    answer = i;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 3, 2};
        int n = 3;
        System.out.println(solution(nums,n));

    }
}
