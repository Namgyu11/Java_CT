package codingTest.preCT_02.preCT_03_01.표현가능한이진트리.연속펄스부분수열의합.preCT_03_02.ct01;

public class Solution {
    public static int solution(String s, int n) {
        int answer = 0;
        for (int i = 0; i <s.length(); i++) {
            if(Integer.parseInt(String.valueOf(s.charAt(i))) == n){
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}
