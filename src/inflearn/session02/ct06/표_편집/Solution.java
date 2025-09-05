package inflearn.session02.ct06.표_편집;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        int[] prev = new int[n];
        int[] next = new int[n];
        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        next[n - 1] = -1;
        
        Deque<Integer> removed = new ArrayDeque<>();
        int curr = k;
        
        for (String c : cmd) {
            char op = c.charAt(0);
            if (op == 'U') {
                int x = Integer.parseInt(c.substring(2));
                for (int i = 0; i < x; i++) {
                    curr = prev[curr];
                }
            } else if (op == 'D') {
                int x = Integer.parseInt(c.substring(2));
                for (int i = 0; i < x; i++) {
                    curr = next[curr];
                }
            } else if (op == 'C') {
                removed.push(curr);
                int p = prev[curr];
                int nx = next[curr];
                if (p != -1) {
                    next[p] = nx;
                }
                if (nx != -1) {
                    prev[nx] = p;
                }
                curr = (nx != -1) ? nx : p;
            } else {
                int r = removed.pop();
                int p = prev[r];
                int nx = next[r];
                if (p != -1) {
                    next[p] = r;
                }
                if (nx != -1) {
                    prev[nx] = r;
                }
            }
        }
        
        char[] ans = new char[n];
        Arrays.fill(ans, 'X');
        int node = 0;        while (node != -1) {
            ans[node] = 'O';
            node = next[node];
        }
        return new String(ans);
    }
}
