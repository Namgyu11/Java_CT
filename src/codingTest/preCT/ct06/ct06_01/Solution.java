package codingTest.preCT.ct06.ct06_01;

import java.util.Arrays;

public class Solution {
    public  static int solution(int[] useageArr, int fee) {
        int answer = 0;
        int sum= Arrays.stream(useageArr).sum();
        answer = sum * fee;
        return answer;
    }

    public static void main(String[] args) {

        int[] a = {1,3,5};
        int b = 5;
    }
}
