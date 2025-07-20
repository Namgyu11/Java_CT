package codingTest.preCT_03.preCT_03_01.preCT_03_05.ct04;

import java.util.Arrays;


//23-10-08(풀이) -- 다시 풀기 !!
public class Solution {
    public int solution(int[] A, int K) {
        int answer = 0;
        Arrays.sort(A);
        for (int i = 0; i <A.length; i++) {
            if(K >= A[i]){
                K -= A[i];
                answer++;
            }else break;
        }
        return answer;
    }
}
