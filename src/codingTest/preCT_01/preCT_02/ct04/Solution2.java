package codingTest.preCT_01.preCT_02.ct04;

//다시 풀기
public class Solution2 {
    public static int solution(int[] A) {
        int gcd = A[0];

        for (int i = 0; i < A.length; i++) {
            int a = gcd;
            int b = A[i];
            while (b != 0){
                int temp = a;
                a = b;
                b = temp % b;
            }
            gcd = a;
        }

        return gcd;
    }

    public static void main(String[] args) {
        int[] A = {6, 12, 4};
        System.out.println(solution(A));
    }
}
