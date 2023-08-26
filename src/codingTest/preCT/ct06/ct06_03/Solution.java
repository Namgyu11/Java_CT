package codingTest.preCT.ct06.ct06_03;

public class Solution {
    public static int solution(int n) {
        int answer = 0;
        for (int i = 1; (double) i * i <= n / (double) i; i++) {
            answer = i * i * i;
        }

        return answer;
    }

    public static void main(String[] args) {

        int a = 99;
        System.out.println(solution(a));
    }
}
