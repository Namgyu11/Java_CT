package ktb_ct.week04.week03.week02.week01.ct04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 알고리즘 분류 - 누적 합, 슬라이딩 윈도우
public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());

            int[] visitors = new int[N];
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                  // 방문자 수 입력
                  visitors[i] = Integer.parseInt(st.nextToken());
            }

            int maxVisitors = 0;
            int currentSum = 0;
            int count = 0;

            for (int i = 0; i < X; i++) {
                  currentSum += visitors[i];
            }

            maxVisitors = currentSum;
            count = 1;

            // 최대 방문자 수 계산
            for (int i = X; i < N; i++) {
                  currentSum = currentSum - visitors[i - X] + visitors[i];
                  if (currentSum > maxVisitors) {
                        maxVisitors = currentSum;
                        count = 1;
                  } else if (currentSum == maxVisitors) {
                        count++;
                  }
            }
            if (maxVisitors == 0) {
                  System.out.println("SAD");
            } else {
                  System.out.println(maxVisitors);
                  System.out.println(count);
            }


      }

}
