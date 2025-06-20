package codingTest.programmers.lv3.억억단을_외우자;

import java.util.*;

class Solution {
    public int[] solution(int e, int[] starts) {
        int[] tau = new int[e+1];
        for (int i = 1; i <= e; i++) {
            for (int j = i; j <= e; j += i) {
                tau[j]++;
            }
        }
        int[] best = new int[e+2];
        best[e] = e;
        for (int k = e-1; k >= 1; k--) {
            int cand1 = k, cand2 = best[k+1];
            if (tau[cand1] > tau[cand2]) {
                best[k] = cand1;
            } else if (tau[cand1] < tau[cand2]) {
                best[k] = cand2;
            } else {
                best[k] = cand1;
            }
        }
        int[] answer = new int[starts.length];
        for (int i = 0; i < starts.length; i++) {
            answer[i] = best[starts[i]];
        }
        return answer;
    }
}
