package codingTest.preCT_02.preCT_03_01.ct01.ct04.ct05.표현가능한이진트리.연속펄스부분수열의합.preCT_03_02.preCT_03_03.preCT_03_04.ct04;

//23-10-08(풀이) -- 다시 풀기 !!
public class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int cnt = 0;
        for (int i = 0; i <arr.length; i++) {
            if(arr[i] == 1){
                cnt++;
                answer = Math.max(answer,cnt);
            }else {
                cnt = 0;
            }
        }
        return answer;
    }

}
