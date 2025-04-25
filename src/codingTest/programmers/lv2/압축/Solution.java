package codingTest.programmers.lv2.압축;

import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dict = new HashMap<>();
        for (int i = 1; i <= 26; i++) {
            dict.put(String.valueOf((char)('A' + i - 1)), i);
        }
        int index = 27;
        List<Integer> output = new ArrayList<>();
        int i = 0, len = msg.length();
        while (i < len) {
            int l = 1;
            String w = msg.substring(i, i + 1);
            while (i + l <= len && dict.containsKey(msg.substring(i, i + l))) {
                w = msg.substring(i, i + l);
                l++;
            }
            if (i + l <= len) {
                dict.put(msg.substring(i, i + l), index++);
            }
            output.add(dict.get(w));
            i += w.length();
        }
        return output.stream().mapToInt(Integer::intValue).toArray();
    }
}
