package codingTest.programmers.lv3.캠핑;

import java.util.*;

public class Solution {
    public int solution(int n, int[][] data) {
        int N = n;
        int[] xs = new int[N], ys = new int[N];
        for (int i = 0; i < N; i++) {
            xs[i] = data[i][0];
            ys[i] = data[i][1];
        }
        Arrays.sort(xs);
        Arrays.sort(ys);
     
        Map<Integer,Integer> xMap = new HashMap<>();
        Map<Integer,Integer> yMap = new HashMap<>();
        int cx = 0;
        for (int v : xs) {
            if (!xMap.containsKey(v)) {
                xMap.put(v, cx++);
            }
        }
        int cy = 0;
        for (int v : ys) {
            if (!yMap.containsKey(v)) {
                yMap.put(v, cy++);
            }
        }
        int W = cx, H = cy;
        boolean[][] occ = new boolean[W][H];
        int[][] pts = new int[N][2];
        for (int i = 0; i < N; i++) {
            int x = xMap.get(data[i][0]);
            int y = yMap.get(data[i][1]);
            occ[x][y] = true;
            pts[i][0] = x;
            pts[i][1] = y;
        }
        int[][] ps = new int[W+1][H+1];
        for (int i = 0; i < W; i++) {
            int rowSum = 0;
            for (int j = 0; j < H; j++) {
                if (occ[i][j]) {
                    rowSum++;
                }
                ps[i+1][j+1] = ps[i][j+1] + rowSum;
            }
        }
        
        long ans = 0;
        for (int i = 0; i < N; i++) {
            int x1 = pts[i][0], y1 = pts[i][1];
            for (int j = i+1; j < N; j++) {
                int x2 = pts[j][0], y2 = pts[j][1];
                if (x1 == x2 || y1 == y2) {
                    continue;
                }
                if (x1 > x2) { int t=x1;x1=x2;x2=t; }
                if (y1 > y2) { int t=y1;y1=y2;y2=t; }
                int cnt = ps[x2][y2] - ps[x1+1][y2] - ps[x2][y1+1] + ps[x1+1][y1+1];
                if (cnt == 0) {
                    ans++;
                }
            }
        }
        return (int)ans;
    }
}
