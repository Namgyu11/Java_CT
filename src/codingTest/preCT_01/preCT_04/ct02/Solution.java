package codingTest.preCT_01.preCT_04.ct02;

public class Solution {
    public static int solution(String[] arr) {
        int answer;
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            if(i==0){
                temp = Integer.parseInt(arr[i],2);
            }else {
                temp ^= Integer.parseInt(arr[i],2);
            }
        }
        answer = temp;
        return answer;
    }

    public static void main(String[] args) {

        String[] arr ={"10110", "1010", "11110"};
        System.out.println(solution(arr));
    }
}
