package codingTest.CT.CT_month_03.ct03;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int solution(int N, int K, int[][] board) {
        int answer = 0;
        List<int[]> knights = new ArrayList<>();
        int[][] moves = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0) {
                    knights.add(new int[] {i, j});
                }
            }
        }

        for (int[] knight : knights) {
            int maxScore = 0;
            int[] maxMove = null;
            for (int[] move : moves) {
                int newX = knight[0] + move[0];
                int newY = knight[1] + move[1];

                if (newX >= 0 && newX < N && newY >= 0 && newY < N && board[newX][newY] > maxScore) {
                    maxScore = board[newX][newY];
                    maxMove = new int[] {newX, newY};
                }
            }

            if (maxMove != null) {
                answer += maxScore;
                board[maxMove[0]][maxMove[1]] = 0;
            }
        }

        return answer;
    }
}
