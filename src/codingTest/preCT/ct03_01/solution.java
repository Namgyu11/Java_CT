package codingTest.preCT.ct03_01;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class solution {
    public static String solution(String s) {
        String answer = s;
        Stack stack =new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.indexOf(s.charAt(i)) != i){
                String temp = String.valueOf(s.charAt(i));
                answer = answer.replace(temp+temp, "");
            }
        }
        return answer;

    }
    public static void main(String[] args) {
        String s = "aacddaefg";
        System.out.println(solution(s));


    }
}
