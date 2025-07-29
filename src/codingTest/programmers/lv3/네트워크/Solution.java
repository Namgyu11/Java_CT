package codingTest.programmers.lv3.네트워크;

class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, n, computers, visited);
                count++;
            }
        }
        return count;
    }
    
    private void dfs(int u, int n, int[][] comp, boolean[] visited) {
        visited[u] = true;
        for (int v = 0; v < n; v++) {
            if (comp[u][v] == 1 && !visited[v]) {
                dfs(v, n, comp, visited);
            }
        }
    }
}
