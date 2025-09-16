package ktb_ct.week02.ct03.ct03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 알고리즘 분류 : 이분 탐색, 매개 변수 탐색
public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] expenses = new int[N];
            int maxExpense = 0;
            int totalExpense = 0;

            for (int i = 0; i < N; i++) {
                  expenses[i] = Integer.parseInt(br.readLine());
                  maxExpense = Math.max(maxExpense, expenses[i]);
                  totalExpense += expenses[i];
            }

            int left = maxExpense;
            int right = totalExpense;
            int result = totalExpense;

            while (left <= right) {
                  int mid = (left + right) / 2;
                  if (canWithdrawInMTries(expenses, N, M, mid)) {
                        result = mid;
                        right = mid - 1;
                  } else {
                        left = mid + 1;
                  }
            }

            System.out.println(result);

      }

      private static boolean canWithdrawInMTries(int[] expenses, int N, int M, int K) {
            int count = 1;
            int currentSum = 0;

            for (int i = 0; i < N; i++) {
                  if (currentSum + expenses[i] > K) {
                        count++;
                        currentSum = expenses[i];
                        if (count > M) {
                              return false;
                        }
                  } else {
                        currentSum += expenses[i];
                  }
            }

            return true;
      }
}
