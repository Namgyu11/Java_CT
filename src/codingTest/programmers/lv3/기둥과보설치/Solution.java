package codingTest.programmers.lv3.기둥과보설치;

import java.util.*;

class Solution {
    public int[][] solution(int n, int[][] build_frame) {
        boolean[][] pillar = new boolean[n+1][n+1];
        boolean[][] beam   = new boolean[n+1][n+1];
        for (int[] cmd : build_frame) {
            int x = cmd[0], y = cmd[1], a = cmd[2], b = cmd[3];
            if (b == 1) {
                if (a == 0) {
                    pillar[x][y] = true;
                } else {
                    beam[x][y] = true;
                }
                if (!isValid(n, pillar, beam)) {
                    if (a == 0) {
                        pillar[x][y] = false;
                    } else {
                        beam[x][y] = false;
                    }
                }
            } else {
                if (a == 0) {
                    pillar[x][y] = false;
                } else {
                    beam[x][y] = false;
                }
                if (!isValid(n, pillar, beam)) {
                    if (a == 0) {
                        pillar[x][y] = true;
                    } else {
                        beam[x][y] = true;
                    }
                }
            }
        }
        List<int[]> res = new ArrayList<>();
        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n; y++) {
                if (pillar[x][y]) {
                    res.add(new int[]{x, y, 0});
                }
                if (beam[x][y]) {
                    res.add(new int[]{x, y, 1});
                }
            }
        }
        Collections.sort(res, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            }
            if (o1[1] != o2[1]) {
                return o1[1] - o2[1];
            }
            return o1[2] - o2[2];
        });
        return res.toArray(new int[res.size()][]);
    }
    
    private boolean isValid(int n, boolean[][] pillar, boolean[][] beam) {
        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n; y++) {
                if (pillar[x][y]) {
                    if (!canInstallPillar(x, y, pillar, beam)) {
                        return false;
                    }
                }
                if (beam[x][y]) {
                    if (!canInstallBeam(x, y, pillar, beam)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    private boolean canInstallPillar(int x, int y, boolean[][] pillar, boolean[][] beam) {
        if (y == 0) {
            return true;
        }
        if (beam[x][y] || (x > 0 && beam[x - 1][y])) {
            return true;
        }
        if (y > 0 && pillar[x][y - 1]) {
            return true;
        }
        return false;
    }
    
    private boolean canInstallBeam(int x, int y, boolean[][] pillar, boolean[][] beam) {
        if ((y > 0 && pillar[x][y - 1]) || (y > 0 && x + 1 < pillar.length && pillar[x + 1][y
                - 1])) {
            return true;
        }
        if (x > 0 && x + 1 < beam.length && beam[x - 1][y] && beam[x + 1][y]) {
            return true;
        }
        return false;
    }
}
