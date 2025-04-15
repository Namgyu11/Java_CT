package codingTest.programmers.lv3.사라지는발판;

class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        return dfs(board, aloc[0], aloc[1], bloc[0], bloc[1], 0);
    }
    int dfs(int[][] board, int ar, int ac, int br, int bc, int turn) {
        if(turn == 0) {
            if (board[ar][ac] == 0) {
                return 0;
            }
        } else {
            if (board[br][bc] == 0) {
                return 0;
            }
        }
        int ret = (turn == 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        boolean moveExist = false;
        if(turn == 0) {
            for (int i = 0; i < 4; i++){
                int nar = ar + dr[i], nac = ac + dc[i];
                if (nar < 0 || nar >= board.length || nac < 0 || nac >= board[0].length) {
                    continue;
                }
                if (board[nar][nac] == 0) {
                    continue;
                }
                moveExist = true;
                board[ar][ac] = 0;
                int next = dfs(board, nar, nac, br, bc, 1);
                board[ar][ac] = 1;
                ret = Math.max(ret, next + 1);
            }
        } else {
            for (int i = 0; i < 4; i++){
                int nbr = br + dr[i], nbc = bc + dc[i];
                if (nbr < 0 || nbr >= board.length || nbc < 0 || nbc >= board[0].length) {
                    continue;
                }
                if (board[nbr][nbc] == 0) {
                    continue;
                }
                moveExist = true;
                board[br][bc] = 0;
                int next = dfs(board, ar, ac, nbr, nbc, 0);
                board[br][bc] = 1;
                ret = Math.min(ret, next + 1);
            }
        }
        if (!moveExist) {
            return 0;
        }
        return ret;
    }
}
