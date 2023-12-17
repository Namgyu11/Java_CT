package codingTest.CT.CT_month_02.ct02;

import java.util.*;

//23-11-11 (풀이) @@@@@@@@ 다시 풀기 @@@@@@@@@
public class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    public int[] solution(int N, String[][] board) {
        int[][] dist = new int[N][N];
        Queue<int[]> queue = new LinkedList<>();

        // 그래플러 위치 찾기 & 큐에 넣기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j].equals("G")) {
                    queue.offer(new int[]{i, j});
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        // BFS를 이용한 최단 거리 계산
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if (dist[nx][ny] > dist[cur[0]][cur[1]] + 1) {
                        dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        // 최대 거리를 가진 빈칸 찾기
        int maxDist = -1;
        int[] answer = new int[2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j].equals("B") && dist[i][j] > maxDist) {
                    maxDist = dist[i][j];
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}
