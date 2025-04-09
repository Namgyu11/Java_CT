package codingTest.bj.bj16236;

import java.io.*;
import java.util.*;
 
public class Main {
    static int N, sharkSize = 2, eatCount = 0, totalTime = 0;
    static int[][] board;
    static int[] dr = {-1, 0, 0, 1}, dc = {0, -1, 1, 0};
 
    static class Point {
        int r, c, dist;
        Point(int r, int c, int dist) {
            this.r = r; this.c = c; this.dist = dist;
        }
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        int sharkR = 0, sharkC = 0;
 
        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 9) {
                    sharkR = i;
                    sharkC = j;
                    board[i][j] = 0;
                }
            }
        }
 
        while(true){
            Point target = bfs(sharkR, sharkC);
            if (target == null) {
                break;
            }
            totalTime += target.dist;
            sharkR = target.r;
            sharkC = target.c;
            board[target.r][target.c] = 0;
            eatCount++;
            if(eatCount == sharkSize) {
                sharkSize++;
                eatCount = 0;
            }
        }
 
        System.out.println(totalTime);
    }
 
    static Point bfs(int sr, int sc) {
        boolean[][] visited = new boolean[N][N];
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(sr, sc, 0));
        visited[sr][sc] = true;
        ArrayList<Point> fishes = new ArrayList<>();
        int minDist = Integer.MAX_VALUE;
 
        while(!queue.isEmpty()){
            Point cur = queue.poll();
            if (cur.dist > minDist) {
                break;
            }
            if(board[cur.r][cur.c] != 0 && board[cur.r][cur.c] < sharkSize) {
                fishes.add(cur);
                minDist = cur.dist;
            }
 
            for (int i = 0; i < 4; i++){
                int nr = cur.r + dr[i], nc = cur.c + dc[i];
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                    continue;
                }
                if(!visited[nr][nc] && board[nr][nc] <= sharkSize) {
                    visited[nr][nc] = true;
                    queue.offer(new Point(nr, nc, cur.dist + 1));
                }
            }
        }

        if (fishes.isEmpty()) {
            return null;
        }
        Collections.sort(fishes, new Comparator<Point>() {
            public int compare(Point a, Point b) {
                if (a.r == b.r) {
                    return a.c - b.c;
                }
                return a.r - b.r;
            }
        });
        return fishes.get(0);
    }
}
