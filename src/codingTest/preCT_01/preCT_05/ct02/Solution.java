package codingTest.preCT_01.preCT_05.ct02;

public class Solution {
    public static boolean solution(int n) {
        boolean answer = true;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if(n % i == 0){
                count++;
            }
        }
        if(count != 2){
            answer =false;
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}
