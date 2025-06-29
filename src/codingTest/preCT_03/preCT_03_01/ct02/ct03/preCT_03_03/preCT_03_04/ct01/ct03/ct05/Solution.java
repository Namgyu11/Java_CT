package codingTest.preCT_03.preCT_03_01.ct02.ct03.preCT_03_03.preCT_03_04.ct01.ct03.ct05;

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
