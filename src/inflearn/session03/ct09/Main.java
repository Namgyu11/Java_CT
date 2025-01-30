package inflearn.session03.ct09;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] grid = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxSum = getMaxSum(N, grid);

        System.out.println(maxSum);

    }

    private static int getMaxSum(int N, int[][] grid) {
        int maxSum = 0;
        int diag1Sum = 0;
        int diag2Sum = 0;

        for(int i = 0; i < N; i++){
            int rowSum = 0;
            int colSum = 0;
            for (int j = 0; j < N; j++) {
                rowSum += grid[i][j];
                colSum += grid[j][i];
            }
            maxSum = Math.max(maxSum, rowSum);
            maxSum = Math.max(maxSum, colSum);

            diag1Sum += grid[i][i];
            diag2Sum += grid[i][N - 1 - i];
        }
        maxSum = Math.max(maxSum, diag1Sum);
        maxSum = Math.max(maxSum, diag2Sum);
        return maxSum;
    }
}
