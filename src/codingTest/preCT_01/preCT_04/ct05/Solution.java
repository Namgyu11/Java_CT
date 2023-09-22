package codingTest.preCT_01.preCT_04.ct05;

public class Solution {
    public static String solution(String[] arr) {
        String answer = "";
        for (int i = 0; i < arr.length; i++) {
            if(i == arr.length -1){
                answer += arr[i];
            }else {
                answer += arr[i] + ",";
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] arr = {"naver", "kakao"};
    }
}
