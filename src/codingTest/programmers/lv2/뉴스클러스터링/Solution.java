package codingTest.programmers.lv2.뉴스클러스터링;

import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> map1 = buildMultiset(str1);
        Map<String, Integer> map2 = buildMultiset(str2);
        
        if (map1.isEmpty() && map2.isEmpty()) {
            return 65536;
        }
        
        int intersection = 0, union = 0;
        Set<String> keys = new HashSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());
        
        for (String key : keys) {
            int c1 = map1.getOrDefault(key, 0);
            int c2 = map2.getOrDefault(key, 0);
            intersection += Math.min(c1, c2);
            union += Math.max(c1, c2);
        }
        
        double jaccard = (double) intersection / union;
        return (int) (jaccard * 65536);
    }
    
    private Map<String, Integer> buildMultiset(String s) {
        Map<String, Integer> map = new HashMap<>();
        s = s.toLowerCase();
        for (int i = 0; i + 1 < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(i + 1);
            if (Character.isLetter(c1) && Character.isLetter(c2)) {
                String key = "" + c1 + c2;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
        return map;
    }
}
