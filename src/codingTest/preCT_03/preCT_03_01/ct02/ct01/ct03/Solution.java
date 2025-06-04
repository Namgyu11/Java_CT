package codingTest.preCT_03.preCT_03_01.ct02.ct01.ct03;

//23-10-06(풀이) -- 다시 풀기 !!
class Solution {
    public int solution(int n) {
        long answer = 1;
        int mod = (int)1e9 + 7;
        int digits = n/2;

        if(digits > 0){
            answer *= 9;
            digits--;
        }

        while(digits-- >0){
            answer = (answer * 10)%mod;
        }
        if(n % 2 == 1) {
            answer = (answer *10)%mod;
        }

        return (int)answer;
    }
}


