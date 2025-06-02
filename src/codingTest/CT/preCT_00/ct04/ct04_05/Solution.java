package codingTest.CT.preCT_00.ct04.ct04_05;

public class Solution {
    public String solution(String s) {
        String answer = "";

        for(Character c: s.toCharArray()){
            if(Character.isLowerCase(c)){
                answer += Character.toUpperCase(c);
            }else {
                answer+= Character.toLowerCase(c);
            }
        }
        return answer;
    }
}
