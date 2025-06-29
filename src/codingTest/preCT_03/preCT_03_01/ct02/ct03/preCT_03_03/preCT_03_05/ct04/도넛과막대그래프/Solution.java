package codingTest.preCT_03.preCT_03_01.ct02.ct03.preCT_03_03.preCT_03_05.ct04.도넛과막대그래프;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(int[][] edges) {
        int max = 0;
        for (int[] e : edges) {
            max = Math.max(max, Math.max(e[0], e[1]));
        }

        int[] in = new int[max+1], out = new int[max+1];
        boolean[] exist = new boolean[max+1];
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            exist[u] = true;
            exist[v] = true;
            out[u]++;
            in[v]++;
        }
        int extra = -1;

        for (int i = 1; i <= max; i++) {
            if (exist[i] && in[i] == 0 && out[i] > 0) {
                if (extra == -1 || out[i] > out[extra]) {
                    extra = i;
                }
            }
        }
        int[] parent = new int[max+1];

        for (int i = 1; i <= max; i++) {
            parent[i] = i;
        }

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            if (u == extra || v == extra) {
                continue;
            }
            union(parent, u, v);
        }
        Map<Integer, Integer> compV = new HashMap<>();

        for (int i = 1; i <= max; i++) {
            if (!exist[i] || i == extra) {
                continue;
            }
            int root = find(parent, i);
            compV.put(root, compV.getOrDefault(root, 0) + 1);
        }
        Map<Integer, Integer> compE = new HashMap<>();

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            if (u == extra || v == extra) {
                continue;
            }
            int root = find(parent, u);
            compE.put(root, compE.getOrDefault(root, 0) + 1);
        }
        int donut = 0, bar = 0, eight = 0;

        for (int root : compV.keySet()) {
            int vCount = compV.get(root);
            int eCount = compE.getOrDefault(root, 0);
            if (eCount == vCount) {
                donut++;
            } else if (eCount == vCount - 1) {
                bar++;
            } else if (eCount == vCount + 1) {
                eight++;
            }
        }
        return new int[]{extra, donut, bar, eight};
    }
    private int find(int[] p, int x) {
        if (p[x] != x) {
            p[x] = find(p, p[x]);
        }
        return p[x];
    }
    private void union(int[] p, int a, int b) {
        a = find(p, a);
        b = find(p, b);
        if (a != b) {
            p[b] = a;
        }
    }
}
