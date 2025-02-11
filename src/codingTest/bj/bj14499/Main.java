package codingTest.bj.bj14499;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, x, y, K;
    static int[][] map;
    static int[] dice = new int[6];
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 처리
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (st.hasMoreTokens()) {
            int dir = Integer.parseInt(st.nextToken()) - 1; // 0-based index

            // Step 1: 이동할 위치 계산
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 지도 밖이면 무시
            if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                continue;
            }

            rollDice(dir);

            if (map[nx][ny] == 0) {
                map[nx][ny] = dice[5];
            } else {
                dice[5] = map[nx][ny];
                map[nx][ny] = 0;
            }

            x = nx;
            y = ny;
            sb.append(dice[0]).append("\n");
        }

        System.out.print(sb);
    }

    private static void rollDice(int dir) {
        int[] temp = dice.clone();
        switch (dir) {
            case 0:
                dice[0] = temp[3];
                dice[2] = temp[0];
                dice[3] = temp[5];
                dice[5] = temp[2];
                break;
            case 1:
                dice[0] = temp[2];
                dice[2] = temp[5];
                dice[3] = temp[0];
                dice[5] = temp[3];
                break;
            case 2:
                dice[0] = temp[4];
                dice[1] = temp[0];
                dice[4] = temp[5];
                dice[5] = temp[1];
                break;
            case 3:
                dice[0] = temp[1];
                dice[1] = temp[5];
                dice[4] = temp[0];
                dice[5] = temp[4];
                break;
        }
    }
}
