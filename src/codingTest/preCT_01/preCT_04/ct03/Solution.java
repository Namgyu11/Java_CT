package codingTest.preCT_01.preCT_04.ct03;

public class Solution {
    public static int solution(int n) {
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if(n % i == 0){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int n = 10;
        System.out.println(solution(n));
    }
}
