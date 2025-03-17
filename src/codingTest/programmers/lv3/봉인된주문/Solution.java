package codingTest.programmers.lv3.봉인된주문;

import java.util.*;

class Solution {
    public String solution(long n, String[] bans) {
        long[] power = new long[12];
        power[0] = 1;
        for (int i = 1; i <= 11; i++) {
            power[i] = power[i - 1] * 26;
        }
        
     
        Map<Integer, List<Long>> bannedMap = new HashMap<>();
        for (String s : bans) {
            int len = s.length();
            long val = 0;
            for (int i = 0; i < len; i++) {
                val = val * 26 + (s.charAt(i) - 'a');
            }
            bannedMap.computeIfAbsent(len, k -> new ArrayList<>()).add(val);
        }
        for (int len : bannedMap.keySet()) {
            Collections.sort(bannedMap.get(len));
        }
        
        long sum = 0;
        int targetLength = 0;
        for (int L = 1; L <= 11; L++) {
            long totalForL = power[L]; 
            int bannedCount = bannedMap.containsKey(L) ? bannedMap.get(L).size() : 0;
            long available = totalForL - bannedCount;
            if (sum + available >= n) {
                targetLength = L;
                break;
            }
            sum += available;
        }
        
        long offset = n - sum - 1;
        List<Long> bannedList = bannedMap.getOrDefault(targetLength, new ArrayList<>());
        long prev = -1;  
        long ansNum = 0;
        for (long b : bannedList) {
            long gap = b - (prev + 1); 
            if (offset < gap) {
                ansNum = prev + 1 + offset;
                prev = -2; 
                break;
            }
            offset -= gap;
            prev = b;
        }
        if (prev != -2) { 
            ansNum = prev + 1 + offset;
        }
        
        char[] result = new char[targetLength];
        for (int i = targetLength - 1; i >= 0; i--) {
            result[i] = (char)('a' + (int)(ansNum % 26));
            ansNum /= 26;
        }
        return new String(result);
    }
}
