package codingTest.programmers.lv3.외벽점검;

import java.util.*;

class Solution {
    private int bestAnswer;
    private int[] distArr;
    private int[] weakExtended;
    private int wlen;
    private int totalFriends;

    public int solution(int n, int[] weak, int[] dist) {
        wlen = weak.length;
        weakExtended = new int[2 * wlen];
        for (int i = 0; i < wlen; i++) {
            weakExtended[i] = weak[i];
            weakExtended[i + wlen] = weak[i] + n;
        }

        distArr = dist;
        totalFriends = distArr.length;
        bestAnswer = Integer.MAX_VALUE;

        boolean[] used = new boolean[totalFriends];
        List<Integer> perm = new ArrayList<>();
        dfsPerm(used, perm);

        return (bestAnswer == Integer.MAX_VALUE) ? -1 : bestAnswer;
    }

    private void dfsPerm(boolean[] used, List<Integer> perm) {
        if (perm.size() == totalFriends) {
            testPermutation(perm);
            return;
        }
        for (int i = 0; i < totalFriends; i++) {
            if (!used[i]) {
                used[i] = true;
                perm.add(distArr[i]);
                dfsPerm(used, perm);
                perm.remove(perm.size() - 1);
                used[i] = false;
            }
        }
    }

    private void testPermutation(List<Integer> perm) {
        for (int start = 0; start < wlen; start++) {
            int friends = 1;
            int coverage = weakExtended[start] + perm.get(friends - 1);
            int idx = start;
            while (idx < start + wlen) {
                if (weakExtended[idx] <= coverage) {
                    idx++;
                } else {
                    friends++;
                    if (friends > totalFriends) {
                        break;
                    }
                    coverage = weakExtended[idx] + perm.get(friends - 1);
                }
            }
            if (idx == start + wlen) {
                bestAnswer = Math.min(bestAnswer, friends);
            }
        }
    }
}
