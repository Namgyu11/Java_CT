package codingTest.bj.bj02638;

import java.io.*;
import java.util.*;
 
public class Main {
    static int N, M;
    static int[][] board;
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
 
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
 
        int hours = 0;
        while (true) {
            boolean[][] visited = new boolean[N][M];
            Queue<Point> queue = new LinkedList<>();
            queue.offer(new Point(0, 0));
            visited[0][0] = true;
 
            while (!queue.isEmpty()) {
                Point p = queue.poll();
                int r = p.r, c = p.c;
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d], nc = c + dc[d];
                    if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
                        continue;
                    }
                    if (visited[nr][nc]) {
                        continue;
                    }
                    if (board[nr][nc] == 1) {
                        continue;
                    }
                    visited[nr][nc] = true;
                    queue.offer(new Point(nr, nc));
                }
            }
 
            ArrayList<Point> meltList = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board[i][j] == 1) {
                        int count = 0;
                        for (int d = 0; d < 4; d++) {
                            int ni = i + dr[d], nj = j + dc[d];
                            if (ni < 0 || ni >= N || nj < 0 || nj >= M) {
                                continue;
                            }
                            if (visited[ni][nj]) {
                                count++;
                            }
                        }
                        if (count >= 2) {
                            meltList.add(new Point(i, j));
                        }
                    }
                }
            }

            if (meltList.isEmpty()) {
                break;
            }
 
            for (Point p : meltList) {
                board[p.r][p.c] = 0;
            }
            hours++;
        }
        System.out.println(hours);
    }
 
    static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
