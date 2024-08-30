package ktb_ct.week03.ct05;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] board = new int[19][19];
    static int[] dx = {1, 0, 1, 1};
    static int[] dy = {0, 1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = -1;

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            board[x][y] = (i % 2 == 1) ? 1 : 2;

            if (checkWin(x, y)) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }

    public static boolean checkWin(int x, int y) {
        int color = board[x][y];

        for (int d = 0; d < 4; d++) {
            int count = 1;

            // 한 방향으로 체크
            count += countStones(x, y, dx[d], dy[d], color);
            // 반대 방향으로 체크
            count += countStones(x, y, -dx[d], -dy[d], color);

            if (count == 5) {
                return true;
            }
        }

        return false;
    }

    public static int countStones(int x, int y, int dx, int dy, int color) {
        int count = 0;
        int nx = x + dx;
        int ny = y + dy;

        while (nx >= 0 && nx < 19 && ny >= 0 && ny < 19 && board[nx][ny] == color) {
            count++;
            nx += dx;
            ny += dy;
        }

        return count;
    }
}