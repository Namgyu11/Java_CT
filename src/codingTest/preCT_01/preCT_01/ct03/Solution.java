package codingTest.preCT_01.preCT_01.ct03;

public class Solution {
    public static int solution(int[] A) {
        int answer = 0;
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] < A[j] && answer < (A[j] - A[i])) {
                    answer = A[j] - A[i];
                }
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        int[] a = {100000, 99000, 99000, 98000, 97000};
        System.out.println(solution(a));
    }
}
