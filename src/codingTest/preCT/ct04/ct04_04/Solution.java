package codingTest.preCT.ct04.ct04_04;

public class Solution {
    public static int solution(int n) {
        int answer = 0;

        for (int i = 1; i <=n; i++) {
            if(n/i == i){
                answer = i;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        int a =36;
        System.out.println(solution(a));

    }
}
