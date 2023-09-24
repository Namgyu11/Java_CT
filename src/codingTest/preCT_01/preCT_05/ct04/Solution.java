package codingTest.preCT_01.preCT_05.ct04;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if(i * i == n){
                answer = i;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}
