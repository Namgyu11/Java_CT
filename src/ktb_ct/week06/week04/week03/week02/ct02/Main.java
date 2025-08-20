package ktb_ct.week06.week04.week03.week02.ct02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

      private static boolean[] visited;
      private static List<Integer>[] graph;

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());

            graph = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++) {
                  graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                  StringTokenizer st = new StringTokenizer(br.readLine());
                  int u = Integer.parseInt(st.nextToken());
                  int v = Integer.parseInt(st.nextToken());
                  graph[u].add(v);
                  graph[v].add(u);
            }

            visited = new boolean[n + 1];
            int infectedCount = dfs(1) - 1;

            System.out.println(infectedCount);
      }

      public static int dfs(int node) {
            visited[node] = true;
            int count = 1;

            for (int neighbor : graph[node]) {
                  if (!visited[neighbor]) {
                        count += dfs(neighbor);
                  }
            }

            return count;
      }

}
