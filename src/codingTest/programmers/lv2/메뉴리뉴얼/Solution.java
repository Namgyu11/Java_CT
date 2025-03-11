package codingTest.programmers.lv2.메뉴리뉴얼;

import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        Map<String, Integer> map = new HashMap<>();
        for (String order : orders) {
            char[] arr = order.toCharArray();
            Arrays.sort(arr);
            String sortedOrder = new String(arr);
            int len = sortedOrder.length();
            for (int i = 2; i <= len; i++) {
                generateCombination(sortedOrder, i, 0, new StringBuilder(), map);
            }
        }
        List<String> answerList = new ArrayList<>();
        for (int courseSize : course) {
            int maxFrequency = 0;
            List<String> candidates = new ArrayList<>();
            for (String key : map.keySet()) {
                if (key.length() == courseSize) {
                    int count = map.get(key);
                    if (count >= 2) {
                        if (count > maxFrequency) {
                            maxFrequency = count;
                            candidates.clear();
                            candidates.add(key);
                        } else if (count == maxFrequency) {
                            candidates.add(key);
                        }
                    }
                }
            }
            answerList.addAll(candidates);
        }
        Collections.sort(answerList);
        return answerList.toArray(new String[0]);
    }
    
    private void generateCombination(String s, int r, int start, StringBuilder sb, Map<String, Integer> map) {
        if (sb.length() == r) {
            String comb = sb.toString();
            map.put(comb, map.getOrDefault(comb, 0) + 1);
            return;
        }
        for (int i = start; i < s.length(); i++) {
            sb.append(s.charAt(i));
            generateCombination(s, r, i + 1, sb, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
