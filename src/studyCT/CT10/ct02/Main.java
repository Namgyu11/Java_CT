package studyCT.CT10.ct02;

import java.io.*;

public class Main {

      public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());

            int[] dp = new int[n + 1];
            dp[1] = 1;

            if (n > 1) { // n이 1보다 큰 경우에만 dp[2]를 설정

                  // 2x2 직사각형을 채우는 방법의 수는 2
                  dp[2] = 2;
            }

            for (int i = 3; i <= n; i++) {
                  // 점화식 적용: dp[i]는 dp[i-1]과 dp[i-2]의 합을 10007로 나눈 나머지
                  dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
                  System.out.println(dp[n]);
            }
      }
}


