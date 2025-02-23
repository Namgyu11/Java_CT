package codingTest.programmers.lv2.석유시추;

import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int n = land.length;       
        int m = land[0].length;     

        boolean[][] visited = new boolean[n][m];
        List<Lump> lumps = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    int size = 0;
                    HashSet<Integer> colSet = new HashSet<>();
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    
                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        int r = cur[0], c = cur[1];
                        if (visited[r][c]) {
                            continue;
                        }
                        visited[r][c] = true;
                        size++;
                        colSet.add(c);
                        
                        int[] dr = { -1, 1, 0, 0 };
                        int[] dc = { 0, 0, -1, 1 };
                        for (int d = 0; d < 4; d++) {
                            int nr = r + dr[d];
                            int nc = c + dc[d];
                            if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                                continue;
                            }
                            if (land[nr][nc] == 1 && !visited[nr][nc]) {
                                queue.offer(new int[]{nr, nc});
                            }
                        }
                    }
                    lumps.add(new Lump(size, colSet));
                }
            }
        }
        
        int[] colSum = new int[m];
        for (Lump lump : lumps) {
            for (int col : lump.cols) {
                colSum[col] += lump.size;
            }
        }
        
        int answer = 0;
        for (int c = 0; c < m; c++) {
            answer = Math.max(answer, colSum[c]);
        }
        
        return answer;
    }
}

class Lump {
    int size;              
    HashSet<Integer> cols;  

    public Lump(int size, HashSet<Integer> cols) {
        this.size = size;
        this.cols = cols;
    }
}