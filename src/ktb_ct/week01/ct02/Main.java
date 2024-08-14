package ktb_ct.week01.ct02;

import java.io.*;
import java.util.*;

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
