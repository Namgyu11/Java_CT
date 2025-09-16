package ktb_ct.week02.ct03.자물쇠와열쇠;

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int M = key.length;
        int N = lock.length;
        int extend = N + 2 * (M - 1);
        int[][] board = new int[extend][extend];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i + M - 1][j + M - 1] = lock[i][j];
            }
        }
        int[][] rotated = key;
        for (int rotation = 0; rotation < 4; rotation++) {
            for (int x = 0; x <= extend - M; x++) {
                for (int y = 0; y <= extend - M; y++) {
                    for (int i = 0; i < M; i++) {
                        for (int j = 0; j < M; j++) {
                            board[x + i][y + j] += rotated[i][j];
                        }
                    }
                    // 여기서 오프셋을 M-1로 변경
                    if (check(board, M - 1, N)) {
                        return true;
                    }
                    for (int i = 0; i < M; i++) {
                        for (int j = 0; j < M; j++) {
                            board[x + i][y + j] -= rotated[i][j];
                        }
                    }
                }
            }
            rotated = rotate(rotated);
        }
        return false;
    }

    private int[][] rotate(int[][] mat) {
        int n = mat.length;
        int[][] ret = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ret[j][n - 1 - i] = mat[i][j];
            }
        }
        return ret;
    }

    private boolean check(int[][] board, int offset, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[offset + i][offset + j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
