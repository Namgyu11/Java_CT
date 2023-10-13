package codingTest.CT.CT01.ct01;


//23-10-12(풀이) -- 다시 풀기
public class Solution {
    public static int solution(int n) {
        int answer = 0;
        boolean[] prime = new boolean[n]; // n보다 작은 숫자들에 대한 소수 여부 배열
        for(int i=2; i<n; i++)
            prime[i] = true; // 초기에 모든 숫자들을 소수라고 가정

        // 에라토스테네스의 체 알고리즘 적용
        for(int i=2; i*i<n; i++){
            if(prime[i]){
                for(int j=i*i; j<n; j+=i){
                    prime[j] = false;
                }
            }
        }

        for(boolean b : prime) {
            if (b) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 15;
        System.out.println(solution(n));
    }
}
