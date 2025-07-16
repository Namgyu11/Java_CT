package codingTest.preCT_02.preCT_03_01.ct01.preCT_03_02.ct03;

public class Solution {
    public String solution(int[] arr, String prefix, String separator, String postfix) {
        String answer = "";
        answer += prefix;
        for (int i = 0; i <arr.length; i++) {
            if(i == arr.length -1){
                answer += String.valueOf(arr[i]) + postfix;
            }else {
                answer += String.valueOf(arr[i]) + separator;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}
