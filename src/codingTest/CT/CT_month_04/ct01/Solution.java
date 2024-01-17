package codingTest.CT.CT_month_04.ct01;


//24-01-14(풀이) - 다시 풀기 - 에라토스테네스 체 알고리즘
public class Solution {
    public int solution(int A, int B) {
        boolean[] isPrime = new boolean[B+1];
        int answer = 0;

        for(int i = 2; i <= B; i++) {
            isPrime[i] = true;
        }

        for(int i = 2; i * i <= B; i++) {
            if(isPrime[i]) {
                for(int j = i * i; j <= B; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for(int i = A; i <= B; i++) {
            if(isPrime[i]) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

    }

}
