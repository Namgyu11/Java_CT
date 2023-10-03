package codingTest.preCT_02.preCT_05.ct04;


//23-10-01 ->다시 풀기
public class Solution {
    final long MOD = 1000000007L;
    public long solution(int n) {
        return (power(2L,n) -1 + MOD) % MOD;
    }
    private long power(long base, int exponent){
        if(exponent == 0){
            return 1;
        }else if( exponent == 1){
            return base % MOD;
        }
        if(exponent % 2 > 0){
        return ((base % MOD) * power((base * base) % MOD, exponent/2)) % MOD;
        }else {
            return power((base * base) % MOD, exponent /2);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(5));
    }
}
