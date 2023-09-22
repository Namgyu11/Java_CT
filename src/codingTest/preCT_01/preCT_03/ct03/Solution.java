package codingTest.preCT_01.preCT_03.ct03;

import java.util.LinkedList;

public class Solution {
    public static int solution(String S) {
        String str = "";
        LinkedList<Character> list = new LinkedList<>();

        for(char c : S.toCharArray()){
            if(!list.isEmpty() && list.peekLast() == c){
                list.pollLast();
            }else{
                list.offer(c);
            }
        }
        for(char c: list){
            str+=c;
        }
        return str == ""? 1:0;
    }

    public static void main(String[] args) {
        String s = "abba";
        System.out.println(solution(s));

    }
}
