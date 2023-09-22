package codingTest.preCT_01.preCT_03.ct04;

import java.util.LinkedList;

//다시 풀어보기 - 아스키코드 활용
public class Solution {
    public static int solution(String s) {
        int result = 0;
        int num = 0;
        int sign = 1;

        for (int i = 0; i <s.length() ; i++) {
            char c = s.charAt(i);

            if(Character.isDigit(c)){
                num = num * 10 + (c - '0');
            }else {
                result += sign * num;
                num = 0;

                if(c == '-') sign = -1;
                else if(c == '+') sign = 1;
            }
        }

        result += sign * num;

        return result;
    }

    public static void main(String[] args) {
        String s ="-3+26-7";
        System.out.println(solution(s));
    }
}
