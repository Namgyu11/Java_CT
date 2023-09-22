package codingTest.preCT_01.preCT_04.ct04;

public class Solution {
    public static String solution(String s) {
        String answer = "";
        int temp = Integer.parseInt(s,16);
        answer = Integer.toBinaryString(temp);
        return answer;
    }

    public static void main(String[] args) {
        String s = "f4";
        System.out.println(solution(s));
    }
}
