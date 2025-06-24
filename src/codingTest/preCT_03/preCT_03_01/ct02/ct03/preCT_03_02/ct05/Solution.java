package codingTest.preCT_03.preCT_03_01.ct02.ct03.preCT_03_02.ct05;

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
