package codingTest.preCT_02.preCT_04.ct04.ct05;

//23-09-30(풀이) - 다시 풀기
public class Solution {
    public static int solution(String[] array, String s) {
        int answer = 0;
        for (int i = 0; i <array.length; i++) {
            String temp = "";
            for (int j = 0; j < Math.min(array[i].length(), s.length()); j++) {
                if(array[i].charAt(j) == s.charAt(j)){
                    temp += s.charAt(j);
                }
            }
            if(array[i].equals(temp)){
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] array = {"ver", "nav" , "n"};
        String s = "naver";
        System.out.println(solution(array,s));

    }
}
