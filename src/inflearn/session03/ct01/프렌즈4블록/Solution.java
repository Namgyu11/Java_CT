package inflearn.session03.ct01.프렌즈4블록;

class Solution {
    public int solution(int m, int n, String[] board) {
        char[][] arr = new char[m][n];
        for (int i = 0; i < m; i++) {
            arr[i] = board[i].toCharArray();
        }
        int totalRemoved = 0;
        while (true) {
            boolean[][] toRemove = new boolean[m][n];
            boolean found = false;
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char c = arr[i][j];
                    if (c != '\0'
                        && c == arr[i][j+1]
                        && c == arr[i+1][j]
                        && c == arr[i+1][j+1]) {
                        toRemove[i][j] = toRemove[i][j+1]
                                       = toRemove[i+1][j] = toRemove[i+1][j+1] = true;
                        found = true;
                    }
                }
            }
            if (!found) {
                break;
            }
            int removedThisRound = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (toRemove[i][j]) {
                        arr[i][j] = '\0';
                        removedThisRound++;
                    }
                }
            }
            totalRemoved += removedThisRound;
    
            for (int j = 0; j < n; j++) {
                int writeRow = m - 1;
                for (int i = m - 1; i >= 0; i--) {
                    if (arr[i][j] != '\0') {
                        arr[writeRow][j] = arr[i][j];
                        writeRow--;
                    }
                }
                for (int i = writeRow; i >= 0; i--) {
                    arr[i][j] = '\0';
                }
            }
        }
        return totalRemoved;
    }
}
