package codingTest.programmers.lv2.캐시;

import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        Deque<String> cache = new LinkedList<>();
        int time = 0;
        for (String city : cities) {
            String cityLower = city.toLowerCase();
            if (cache.contains(cityLower)) {
                time += 1;
                cache.remove(cityLower);
                cache.addLast(cityLower);
            } else {
                time += 5;
                if (cache.size() == cacheSize) {
                    cache.removeFirst();
                }
                cache.addLast(cityLower);
            }
        }
        return time;
    }
}
