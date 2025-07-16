package codingTest.preCT_02.preCT_03_01.표현가능한이진트리.연속펄스부분수열의합.preCT_03_02.preCT_03_03.ct04;

//22-10-07(풀이) - 다시 풀기
public class Solution {
    public static int solution(int A) {
        int answer = 0;
        int[] arr ={50000,10000,5000,1000,500,100,50,10,5,1};

        for (int i = 0; i <arr.length; i++) {
            if(A < arr[i]){
                continue;
            }
            int q = A / arr[i];
            A %= arr[i];
            answer += q;
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}
