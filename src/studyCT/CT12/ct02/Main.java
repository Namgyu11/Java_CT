package studyCT.CT12.ct02;

import java.util.*;
import java.io.*;
public class Main {
      static int N, M, K;
      static char[][] arr;
      static int[][] visited;
      static int[] dx = { -1, 1, 0, 0 };
      static int[] dy = { 0, 0, 1, -1 };
      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new char[N][M];
            visited = new int[N][M];
            for (int i = 0; i < N; i++) {
                  String s = br.readLine();
                  Arrays.fill(visited[i], Integer.MAX_VALUE);
                  for (int j = 0; j < M; j++) {
                        arr[i][j] = s.charAt(j);
                  }
            }

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            Node start = new Node(x, y);

            x = Integer.parseInt(st.nextToken())-1;
            y = Integer.parseInt(st.nextToken())-1;
            Node end = new Node(x, y);

            BFS(start, end);
            System.out.println(visited[end.x][end.y] == Integer.MAX_VALUE ? -1 : visited[end.x][end.y]);
      }

      public static void BFS(Node start, Node end) {
            Queue<Node> q = new LinkedList<>();
            q.add(start);
            visited[start.x][start.y] = 0;

            while(!q.isEmpty()) {
                  Node n = q.poll();
                  if (n.x == end.x && n.y == end.y) {
                        return ;
                  }
                  for (int i = 0; i < 4; ++i) {
                        for (int k = 1; k <= K; ++k) {
                              int nx = n.x + dx[i] * k;
                              int ny = n.y + dy[i] * k;
                              if (nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == '#') {
                                    break;
                              }
                              if (visited[nx][ny] < visited[n.x][n.y] + 1)
                                    break;
                              if (arr[nx][ny] == '.' && visited[nx][ny] == Integer.MAX_VALUE) {
                                    q.add(new Node(nx, ny));
                                    visited[nx][ny] = visited[n.x][n.y]+1;
                              }
                        }
                  }
            }
      }
}

class Node {
      int x, y;
      Node (int x, int y) {
            this.x = x;
            this.y = y;
      }
}