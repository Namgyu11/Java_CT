package codingTest.preCT_03.preCT_03_01.ct02.ct03.preCT_03_03.ct01;

import java.util.Arrays;

public class Solution {
    public int solution(int[] arr, int n) {
        int answer = -1;
        Arrays.sort(arr);
        for (int i = 0; i <arr.length; i++) {
            if(arr[i] >= n){
                answer = arr[i];
                break;
            }
        }
        return answer;
    }
}
