package codingTest.programmers.lv2.순위검색;

import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        Map<String, List<Integer>> map = new HashMap<>();
        
        for (String s : info) {
            String[] arr = s.split(" ");
            String lang = arr[0];
            String job = arr[1];
            String career = arr[2];
            String food = arr[3];
            int score = Integer.parseInt(arr[4]);
            
            String[] conditions = {lang, job, career, food};
            for (int i = 0; i < (1 << 4); i++) {
                StringBuilder keyBuilder = new StringBuilder();
                for (int j = 0; j < 4; j++) {
                    if ((i & (1 << j)) != 0) {
                        keyBuilder.append("-");
                    } else {
                        keyBuilder.append(conditions[j]);
                    }
                }
                String key = keyBuilder.toString();
                map.computeIfAbsent(key, k -> new ArrayList<>()).add(score);
            }
        }
        
        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }
        
        int[] answer = new int[query.length];
        int idx = 0;
        for (String q : query) {
            q = q.replaceAll(" and ", " ");
            String[] parts = q.split(" ");
            String key = parts[0] + parts[1] + parts[2] + parts[3];
            int scoreThreshold = Integer.parseInt(parts[4]);
            
            if (!map.containsKey(key)) {
                answer[idx++] = 0;
                continue;
            }
            List<Integer> list = map.get(key);
            int count = list.size() - lowerBound(list, scoreThreshold);
            answer[idx++] = count;
        }
        return answer;
    }
    
    private int lowerBound(List<Integer> list, int target) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (list.get(mid) >= target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
