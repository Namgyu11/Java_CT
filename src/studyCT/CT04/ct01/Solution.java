package studyCT.CT04.ct01;

public class Solution {
    private int m, n; // 그리드의 행과 열

    public int numIslands(char[][] grid) {
        int count = 0; //섬의 개수
        m = grid.length;
        n = grid[0].length;

        // 그리드의 모든 셀 순회
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    // 연결된 모든 땅을 방문하고 섬의 개수를 증가
                    DFSMarking(grid, i, j);
                    ++count;
                }
            }
        }
        return count;
    }

    private void DFSMarking(char[][] grid, int i, int j) {
        // 현재 위치가 그리드 범위를 벗어나거나, 현재 셀이 물('0')인 경우 DFS 를 종료
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0'; //방문 표시

        DFSMarking(grid, i + 1, j); // 아래
        DFSMarking(grid, i - 1, j); // 위
        DFSMarking(grid, i, j + 1); // 오른쪽
        DFSMarking(grid, i, j - 1); // 왼쪽
    }
}
