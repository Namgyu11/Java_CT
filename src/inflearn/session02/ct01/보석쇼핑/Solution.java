package inflearn.session02.ct01.보석쇼핑;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int[] solution(String[] gems) {
        int n = gems.length;
        Set<String> set = new HashSet<>(Arrays.asList(gems));
        int totalKinds = set.size();
        
        Map<String, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int ansL = 0, ansR = 0;
        
        window.put(gems[0], 1);
        
        while (left <= right && right < n) {
            if (window.size() < totalKinds) {
                right++;
                if (right < n) {
                    window.put(gems[right], window.getOrDefault(gems[right], 0) + 1);
                }
            } else {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    ansL = left;
                    ansR = right;
                }
                String g = gems[left];
                int cnt = window.get(g);
                if (cnt == 1) {
                    window.remove(g);
                } else {
                    window.put(g, cnt - 1);
                }
                left++;
            }
        }
        
        return new int[]{ansL + 1, ansR + 1};
    }
}
