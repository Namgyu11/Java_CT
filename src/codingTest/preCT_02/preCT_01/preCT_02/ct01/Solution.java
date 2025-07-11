package codingTest.preCT_02.preCT_01.preCT_02.ct01;

import java.util.Arrays;

public class Solution {
    public static int solution(int[] useageArr, int fee) {
        int answer = 0;
        answer = Arrays.stream(useageArr).sum()*fee;
        return answer;
    }

    public static void main(String[] args) {

    }
}
