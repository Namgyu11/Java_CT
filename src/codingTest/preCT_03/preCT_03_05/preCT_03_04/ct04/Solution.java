package codingTest.preCT_03.preCT_03_05.preCT_03_04.ct04;

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
