package ktb_ct.week04.week03.week02.week01.ct02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            // 설탕 봉지의 개수 N
            int N = Integer.parseInt(br.readLine());
            // 설탕 봉지의 최소 개수
            int count = 0;

            while (N > 0) {
                  if (N % 5 == 0) {
                        count += N / 5;
                        N = 0;
                        break;
                  } else {
                        N -= 3;
                        count++;
                  }
            }
            if (N < 0) {
                  System.out.println(-1);
            } else {
                  System.out.println(count);
            }
      }
}
