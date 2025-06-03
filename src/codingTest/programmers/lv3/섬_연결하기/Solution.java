package codingTest.programmers.lv3.섬_연결하기;

import java.util.*;

class Solution {
    static class UnionFind {
        int[] parent;
        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }
        boolean union(int a, int b) {
            int ra = find(a), rb = find(b);
            if (ra == rb) {
                return false;
            }
            parent[rb] = ra;
            return true;
        }
    }
    
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, Comparator.comparingInt(a -> a[2]));
        UnionFind uf = new UnionFind(n);
        int total = 0;
        for (int[] edge : costs) {
            int u = edge[0], v = edge[1], w = edge[2];
            if (uf.union(u, v)) {
                total += w;
            }
        }
        return total;
    }
}
