package codingTest.programmers.lv3.숫자_게임;

import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        TreeMap<Integer, Integer> multiset = new TreeMap<>();
        for (int b : B) {
            multiset.put(b, multiset.getOrDefault(b, 0) + 1);
        }
        int wins = 0;
        for (int a : A) {
            Integer key = multiset.higherKey(a);
            if (key == null) {
                key = multiset.firstKey();
            } else {
                wins++;
            }
            int cnt = multiset.get(key);
            if (cnt == 1) {
                multiset.remove(key);
            } else {
                multiset.put(key, cnt - 1);
            }
        }
        return wins;
    }
}
