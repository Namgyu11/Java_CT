package codingTest.programmers.lv3.카운트다운;

class Solution {
    public int[] solution(int target) {
        int[][] options = new int[61][2];
        int idx = 0;
        for (int i = 1; i <= 20; i++) {
            options[idx][0] = i;
            options[idx][1] = 1;
            idx++;
        }
        for (int i = 1; i <= 20; i++) {
            options[idx][0] = 2 * i;
            options[idx][1] = 0;
            idx++;
        }
        for (int i = 1; i <= 20; i++) {
            options[idx][0] = 3 * i;
            options[idx][1] = 0;
            idx++;
        }
        options[idx][0] = 50;
        options[idx][1] = 1;
        idx++;

        int INF = 1000000000;
        int[] dpDarts = new int[target + 1];
        int[] dpFlag = new int[target + 1];
        for (int i = 1; i <= target; i++) {
            dpDarts[i] = INF;
            dpFlag[i] = -1;
        }
        dpDarts[0] = 0;
        dpFlag[0] = 0;

        for (int i = 0; i <= target; i++) {
            if (dpDarts[i] == INF) continue;
            for (int j = 0; j < idx; j++) {
                int v = options[j][0];
                int f = options[j][1];
                if (i + v > target) continue;
                int newIndex = i + v;
                int newDarts = dpDarts[i] + 1;
                int newFlag = dpFlag[i] + f;
                if (newDarts < dpDarts[newIndex]) {
                    dpDarts[newIndex] = newDarts;
                    dpFlag[newIndex] = newFlag;
                } else if (newDarts == dpDarts[newIndex] && newFlag > dpFlag[newIndex]) {
                    dpFlag[newIndex] = newFlag;
                }
            }
        }

        if (dpDarts[target] == INF) {
            return new int[]{0, 0};
        } else {
            return new int[]{dpDarts[target], dpFlag[target]};
        }
    }
}