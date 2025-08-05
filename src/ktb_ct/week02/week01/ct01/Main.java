package ktb_ct.week02.week01.ct01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            int N = Integer.parseInt(br.readLine());
            int[] A = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                  A[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(A);

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                  int target = Integer.parseInt(st.nextToken());
                  // 이진 탐색으로 존재 여부 확인
                  if (binarySearch(A, target)) {
                        sb.append(1).append("\n");
                  } else {
                        sb.append(0).append("\n");
                  }
            }

            System.out.print(sb.toString());
      }

      // 이진 탐색 함수
      public static boolean binarySearch(int[] arr, int target) {
            int left = 0;
            int right = arr.length - 1;

            while (left <= right) {
                  int mid = (left + right) / 2;
                  if (arr[mid] == target) {
                        return true;
                  } else if (arr[mid] < target) {
                        left = mid + 1;
                  } else {
                        right = mid - 1;
                  }
            }

            return false;
      }
}