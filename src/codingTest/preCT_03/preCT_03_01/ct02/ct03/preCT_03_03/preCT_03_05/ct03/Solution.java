package codingTest.preCT_03.preCT_03_01.ct02.ct03.preCT_03_03.preCT_03_05.ct03;


//23-10-08(풀이) -- 다시 풀기 !!
public class Solution {
    public static int solution(int[][] A) {
        int answer = Integer.MAX_VALUE;

        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0)
                    A[i][j] += A[i - 1][j];
                else if (j == i)
                    A[i][j] += A[i - 1][j - 1];
                else
                    A[i][j] += Math.min(A[i - 1][j], A[i - 1][j - 1]);
            }
        }


        for (int i = 0; i < A.length; i++)
            answer = Math.min(answer, A[A.length - 1][i]);

        return answer;
    }

    public static void main(String[] args) {
        int[][] arr = {{1}, {2, 5}, {7, 10, 1}, {9, 4, 4, 5}};
        System.out.println(solution(arr));

    }
}
