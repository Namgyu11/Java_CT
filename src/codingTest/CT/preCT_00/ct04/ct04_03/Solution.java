package codingTest.CT.preCT_00.ct04.ct04_03;

public class Solution {
    public  static String solution(String s) {
        String answer = "";
        String[] str = s.split("");
        for(int i = str.length-1; i >=0; i--){
            answer += str[i];
        }

        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        String s = "apple";
        System.out.println(solution(s));
    }
}
