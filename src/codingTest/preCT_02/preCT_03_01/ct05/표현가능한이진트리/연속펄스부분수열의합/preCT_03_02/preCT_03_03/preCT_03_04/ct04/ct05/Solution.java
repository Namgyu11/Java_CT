package codingTest.preCT_02.preCT_03_01.ct05.표현가능한이진트리.연속펄스부분수열의합.preCT_03_02.preCT_03_03.preCT_03_04.ct04.ct05;

public class Solution {
    public boolean solution(int[] bridge, int jumpSize) {
        boolean answer = true;
        int cnt = 0;
        int temp = 0;
        for (int i = 0; i < bridge.length; i++) {
            if(bridge[i] == 0){
                cnt++;
                temp = Math.max(cnt,temp);
            }else {
                cnt = 0;
            }
        }
        if(temp > jumpSize){
            answer = false;
        }
        return answer;
    }

}
