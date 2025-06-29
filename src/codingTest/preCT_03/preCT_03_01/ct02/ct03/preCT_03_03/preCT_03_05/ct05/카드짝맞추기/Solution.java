package codingTest.preCT_03.preCT_03_01.ct02.ct03.preCT_03_03.preCT_03_05.ct05.카드짝맞추기;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int answer = Integer.MAX_VALUE;
    int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
    public int solution(int[][] board, int r, int c) {
        dfs(board, r, c, 0);
        return answer;
    }

    void dfs(int[][] board, int r, int c, int count) {
        if (count >= answer) {
            return;
        }
        boolean empty = true;

        for (int i=0;i<4;i++){
            for (int j=0;j<4;j++){
                if(board[i][j] != 0){ empty = false; break; }
            }
            if (!empty) {
                break;
            }
        }

        if(empty){
            answer = Math.min(answer, count);
            return;
        }

        for (int num = 1; num <= 6; num++){
            int[] pos1 = null, pos2 = null;
            for (int i=0;i<4;i++){
                for (int j=0;j<4;j++){
                    if(board[i][j]==num){
                        if (pos1 == null) {
                            pos1 = new int[]{i, j};
                        } else {
                            pos2 = new int[]{i, j};
                            break;
                        }
                    }
                }
                if (pos2 != null) {
                    break;
                }
            }
            if (pos1 == null || pos2 == null) {
                continue;
            }
            int d1 = bfs(board, r, c, pos1[0], pos1[1]);
            int d2 = bfs(board, pos1[0], pos1[1], pos2[0], pos2[1]);
            int total1 = d1 + d2 + 2;

            board[pos1[0]][pos1[1]] = 0;
            board[pos2[0]][pos2[1]] = 0;
            dfs(board, pos2[0], pos2[1], count + total1);
            board[pos1[0]][pos1[1]] = num;

            board[pos2[0]][pos2[1]] = num;
            int d3 = bfs(board, r, c, pos2[0], pos2[1]);
            int d4 = bfs(board, pos2[0], pos2[1], pos1[0], pos1[1]);
            int total2 = d3 + d4 + 2;

            board[pos1[0]][pos1[1]] = 0;
            board[pos2[0]][pos2[1]] = 0;
            dfs(board, pos1[0], pos1[1], count + total2);
            board[pos1[0]][pos1[1]] = num;
            board[pos2[0]][pos2[1]] = num;
        }
    }

    int bfs(int[][] board, int sr, int sc, int tr, int tc) {
        boolean[][] visited = new boolean[4][4];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc, 0});
        visited[sr][sc] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], d = cur[2];
            if (r == tr && c == tc) {
                return d;
            }
            for (int i=0;i<4;i++){
                int nr = r + dr[i], nc = c + dc[i];
                if(isValid(nr, nc) && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc, d+1});
                }
                int[] ctrl = ctrlMove(board, r, c, i);
                nr = ctrl[0]; nc = ctrl[1];
                if(!visited[nr][nc]){
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc, d+1});
                }
            }
        }
        return Integer.MAX_VALUE;
    }
    int[] ctrlMove(int[][] board, int r, int c, int dir) {
        int nr = r, nc = c;
        while(true){
            int nextR = nr + dr[dir], nextC = nc + dc[dir];
            if (!isValid(nextR, nextC)) {
                break;
            }
            nr = nextR; nc = nextC;
            if (board[nr][nc] != 0) {
                break;
            }
        }
        return new int[]{nr, nc};
    }
    boolean isValid(int r, int c) {
        return r>=0 && r<4 && c>=0 && c<4;
    }
}
