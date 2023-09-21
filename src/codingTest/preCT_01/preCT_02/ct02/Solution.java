package codingTest.preCT_01.preCT_02.ct02;

import java.util.Arrays;


public class Solution {
    public static String[] solution(String s) {
        String[] str = s.split("[.,!? ]+");
        String[] answer = new String[str.length];

        for (int i = 0; i <str.length ; i++) {
            String temp = new StringBuilder(str[i]).reverse().toString();
            answer[i] =  temp;
        }

        return answer;

    }

    public static void main(String[] args) {
        String s = "HelloWorld! Aasd,!?!.";
        System.out.println(Arrays.toString(solution(s)));
    }
}
