package codingTest.preCT_02.preCT_03_01.ct01.ct04.ct05.표현가능한이진트리.연속펄스부분수열의합.preCT_03_02.ct05;

public class Solution {
    public int solution(int[] arr, int n) {
        int answer = -1;
        for (int i = 0; i <arr.length; i++) {
            if(arr[i] <= n && arr[i] >= answer){
                answer = arr[i];
            }
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}
