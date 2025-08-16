package codingTest.programmers.lv2.단체사진_찍기;

import java.util.*;

class Solution {
    static final char[] FRIENDS = {'A','C','F','J','M','N','R','T'};

    static class Constraint {
        int a, b, val;
        char op;
        Constraint(char x, char y, char op, int val) {
            this.a = x - 'A';
            this.b = y - 'A';
            this.op = op;
            this.val = val;
        }
    }

    public int solution(int n, String[] data) {
        List<Constraint> cons = new ArrayList<>();
        for (String s : data) {
            cons.add(new Constraint(s.charAt(0), s.charAt(2), s.charAt(3), s.charAt(4) - '0'));
        }
        boolean[] used = new boolean[8];
        char[] perm = new char[8];
        int[] pos = new int[26];
        Arrays.fill(pos, -1);
        int[] count = new int[1];
        dfs(0, used, perm, pos, cons, count);
        return count[0];
    }

    private void dfs(int depth, boolean[] used, char[] perm, int[] pos, List<Constraint> cons, int[] count) {
        if (depth == 8) {
            if (check(pos, cons)) {
                count[0]++;
            }
            return;
        }
        for (int i = 0; i < 8; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            perm[depth] = FRIENDS[i];
            int idx = FRIENDS[i] - 'A';
            pos[idx] = depth;
            if (partialCheck(depth, pos, cons)) {
                dfs(depth + 1, used, perm, pos, cons, count);
            }
            pos[idx] = -1;
            used[i] = false;
        }
    }

    private boolean check(int[] pos, List<Constraint> cons) {
        for (Constraint c : cons) {
            int d = Math.abs(pos[c.a] - pos[c.b]) - 1;
            if (c.op == '=' && d != c.val) {
                return false;
            }
            if (c.op == '<' && d >= c.val) {
                return false;
            }
            if (c.op == '>' && d <= c.val) {
                return false;
            }
        }
        return true;
    }

    private boolean partialCheck(int depth, int[] pos, List<Constraint> cons) {
        for (Constraint c : cons) {
            int pa = pos[c.a], pb = pos[c.b];
            if (pa != -1 && pb != -1 && pa <= depth && pb <= depth) {
                int d = Math.abs(pa - pb) - 1;
                if (c.op == '=' && d != c.val) {
                    return false;
                }
                if (c.op == '<' && d >= c.val) {
                    return false;
                }
                if (c.op == '>' && d <= c.val) {
                    return false;
                }
            }
        }
        return true;
    }
}
