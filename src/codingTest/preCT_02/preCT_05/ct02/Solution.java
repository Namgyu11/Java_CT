package codingTest.preCT_02.preCT_05.ct02;

public class Solution {
    public static int solution(int[] nums, int n) {
        int answer = -1;
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i] == n){
                answer = i;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}
