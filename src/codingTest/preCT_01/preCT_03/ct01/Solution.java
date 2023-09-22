package codingTest.preCT_01.preCT_03.ct01;
import java.util.LinkedList;

public class Solution {
    public static String solution(String s) {
        String answer = "";
        LinkedList<Character> list = new LinkedList<>();

        for(char c : s.toCharArray()){
            if(!list.isEmpty() && list.getLast() == c){
                list.removeLast();
            }else {
                list.offer(c);
            }
        }
        for(char c: list){
            answer += c;
        }
        return answer;
    }
    public static void main(String[] args) {
        String s = "abba";
        System.out.println(solution(s));


    }
}
