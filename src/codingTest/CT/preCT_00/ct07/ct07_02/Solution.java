package codingTest.CT.preCT_00.ct07.ct07_02;

import java.util.Arrays;

public class Solution {
    public static int[] solution(int[] nums) {
        Arrays.sort(nums);
        int cnt = 0;
        for (int i = 1; i < nums.length + 1; i++) {
            if((Arrays.binarySearch(nums, i) >= 0) == false){
                //answer[cnt] += i;
                cnt++;
            }
        }
        int[] answer =new int[cnt];
        cnt = 0;
        for (int i = 1; i < nums.length; i++) {
            if((Arrays.binarySearch(nums, i) >= 0) == false){
                answer[cnt] += i;
                cnt++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,6,6,6};
        Arrays.sort(nums);

        //System.out.println();
        System.out.println(Arrays.toString(solution(nums)));
    }
}
