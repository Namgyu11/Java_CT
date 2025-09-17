package codingTest.programmers.lv4.행렬과연산;

import java.util.*;

class Solution {
    public int[][] solution(int[][] rc, String[] operations) {
        int r = rc.length, c = rc[0].length;
        Deque<Integer> left = new ArrayDeque<>();
        Deque<Integer> right = new ArrayDeque<>();
        Deque<Deque<Integer>> mid = new ArrayDeque<>();
        for (int i = 0; i < r; i++) {
            left.addLast(rc[i][0]);
            right.addLast(rc[i][c - 1]);
            Deque<Integer> row = new ArrayDeque<>();
            for (int j = 1; j < c - 1; j++) {
                row.addLast(rc[i][j]);
            }
            mid.addLast(row);
        }

        for (String op : operations) {
            if (op.charAt(0) == 'S') {
                left.addFirst(left.pollLast());
                right.addFirst(right.pollLast());
                mid.addFirst(mid.pollLast());
            } else {
                Deque<Integer> top = mid.peekFirst();
                Deque<Integer> bottom = mid.peekLast();

                int x = left.pollFirst();
                top.addFirst(x);

                x = top.pollLast();
                right.addFirst(x);

                x = right.pollLast();
                bottom.addLast(x);

                x = bottom.pollFirst();
                left.addLast(x);
            }
        }

        int[][] ans = new int[r][c];
        for (int i = 0; i < r; i++) {
            int l = left.pollFirst();
            int rr = right.pollFirst();
            Deque<Integer> row = mid.pollFirst();
            ans[i][0] = l;
            int j = 1;
            while (!row.isEmpty()) {
                ans[i][j++] = row.pollFirst();
            }
            ans[i][c - 1] = rr;
        }
        return ans;
    }
}
