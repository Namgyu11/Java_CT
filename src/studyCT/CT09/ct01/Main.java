package studyCT.CT09.ct01;

import java.util.*;
import java.io.*;

public class Main {

      static List<Integer>[] graph;
      static boolean[] visited;
      static int[] count;

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            graph = new ArrayList[N + 1];
            count = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                  graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                  st = new StringTokenizer(br.readLine());
                  int A = Integer.parseInt(st.nextToken());
                  int B = Integer.parseInt(st.nextToken());
                  graph[B].add(A);
            }

            int maxCount = 0;
            for (int i = 1; i <= N; i++) {
                  visited = new boolean[N + 1];
                  count[i] = dfs(i);
                  maxCount = Math.max(maxCount, count[i]);
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= N; i++) {
                  if (count[i] == maxCount) {
                        sb.append(i).append(" ");
                  }
            }

            System.out.println(sb.toString().trim());
      }

      static int dfs(int node) {
            visited[node] = true;
            int result = 1;

            for (int next : graph[node]) {
                  if (!visited[next]) {
                        result += dfs(next);
                  }
            }

            return result;
      }
}

