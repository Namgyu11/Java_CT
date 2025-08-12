package ktb_ct.week04.week03.week02.week01.ct03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 알고리즘 분류 - 구현
public class Main {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            boolean[][] paper = new boolean[100][100];

            int n = Integer.parseInt(br.readLine());

            // 색종이 위치 입력 및 도화지에 색종이 붙이기
            for (int i = 0; i < n; i++) {
                  st = new StringTokenizer(br.readLine());
                  int x = Integer.parseInt(st.nextToken());
                  int y = Integer.parseInt(st.nextToken());
                  for (int j = x; j < x + 10; j++) {
                        for (int k = y; k < y + 10; k++) {
                              paper[j][k] = true;
                        }
                  }
            }

            // 검은 영역의 넓이 계산
            int blackArea = 0;
            for (int i = 0; i < 100; i++) {
                  for (int j = 0; j < 100; j++) {
                        if (paper[i][j]) {
                              blackArea++;
                        }
                  }
            }

            System.out.println(blackArea);
      }

}
