package codingTest.preCT_02.preCT_05.ct05;

public class Solution {
    public static String solution(int[] arr) {
        int n = arr.length;

        for (int i = 0; i <=(n-2) /2; i++) {
            if(arr[i] > arr[(2*i)+1]){
                return "NO";
            }
            if((2*i)+2 < n && arr[i] > arr[(2*i)+2]){
                return "NO";
            }
        }
        return "YES";
    }

    public static void main(String[] args) {
        int[] arr = {0,5,10,15};
        System.out.println(solution(arr));
    }
}
