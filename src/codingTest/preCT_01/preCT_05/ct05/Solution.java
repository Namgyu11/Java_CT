package codingTest.preCT_01.preCT_05.ct05;


//다시 풀어보기
public class Solution {
    public String solution(String s) {
        String answer = "";
        for(char c : s.toCharArray()){
            if(Character.isLowerCase(c)){
                answer+= Character.toUpperCase(c);
            }else {
                answer += Character.toLowerCase(c);
            }
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}
