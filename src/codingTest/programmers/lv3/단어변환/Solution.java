package codingTest.programmers.lv3.단어변환;

import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean found = false;
        for (String w : words) {
            if (w.equals(target)) {
                found = true;
                break;
            }
        }
        if (!found) {
            return 0;
        }

        int n = words.length;
        boolean[] visited = new boolean[n];
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(begin, 0));

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            String w = cur.word;
            int steps = cur.steps;
            if (w.equals(target)) {
                return steps;
            }

            for (int i = 0; i < n; i++) {
                if (!visited[i] && isOneDiff(w, words[i])) {
                    visited[i] = true;
                    q.offer(new Pair(words[i], steps + 1));
                }
            }
        }
        return 0;
    }

    private boolean isOneDiff(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (++diff > 1) {
                    return false;
                }
            }
        }
        return diff == 1;
    }

    private static class Pair {
        String word;
        int steps;
        Pair(String w, int s) {
            word = w;
            steps = s;
        }
    }
}
