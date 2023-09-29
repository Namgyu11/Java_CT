package codingTest.preCT_02.preCT_03.ct04;

import java.util.*;
class Solution {
    public static int solution(int A, int B) {
        int answer = 0;
        String as = String.format("%7s",Integer.toBinaryString(A));
        String bs = String.format("%7s",Integer.toBinaryString(B));
        for (int i = 0; i <as.length(); i++) {
            if(as.charAt(i) != bs.charAt(i)){
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        int a = 29;
        int b = 15;
        System.out.println(solution(a,b));
    }
}
