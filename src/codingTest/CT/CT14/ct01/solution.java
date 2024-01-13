package codingTest.CT.CT14.ct01;


//24-01-11 풀이 - 다시 풀기 (유쿨리드 호제법)
public class solution {
    public int solution(int N, int M) {
        return N + M - gcd(N, M);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

}
