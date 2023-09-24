package codingTest.preCT_01.preCT_05.ct03;

public class Solution {
    public String solution(String s) {
        String answer = "";
        String[] str = s.split("");

        for (int i = str.length-1; i >=0 ; i--) {
            answer+= str[i];
        }

        return answer;
    }

    public static void main(String[] args) {

    }
}
