package codingTest.preCT_01.preCT_01.ct02;


//9월 19일 풀이 -> 다시 풀어보자

public class Solution {
    public static boolean solution(int num) {
        boolean answer = true;
        if(num % 4 == 1){
            answer = false;
        }

        return answer;
    }

    public static void main(String[] args) {
        int num = 20;
        System.out.println(solution(num));
    }
}
