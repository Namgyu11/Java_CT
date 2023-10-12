package codingTest.bj.bj01890;

import java.util.Scanner;

public class Main {
    static  int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        int[][] board = new int[N + 1][N + 1];
        long[][] dp = new long[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <=N; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        dp[1][1] = 1;

        for (int i = 1; i <=N; i++) {
            for (int j = 1; j <=N ; j++) {
                int jump = board[i][j];
                if(jump == 0 || dp[i][j]  == 0){
                    continue;
                }
                if(i + jump <= N){
                    dp[i + jump][j] += dp[i][j];
                }
                if(j + jump <= N){
                    dp[i][j+ jump] += dp[i][j];
                }
            }
        }

        System.out.println(dp[N][N]);
    }
}
