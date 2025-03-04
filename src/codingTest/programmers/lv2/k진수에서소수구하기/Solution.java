package codingTest.programmers.lv2.k진수에서소수구하기;

import java.util.*;

class Solution {
    public int solution(int n, int k) {
        String converted = convertToBase(n, k);
        String[] candidates = converted.split("0");
        int count = 0;
        
        for (String candidate : candidates) {
            if (candidate.equals("")) {
                continue;
            }
            long num = Long.parseLong(candidate);
            if (num <= 1) {
                continue;
            }
            if (isPrime(num)) {
                count++;
            }
        }
        return count;
    }
    
    private String convertToBase(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        return sb.reverse().toString();
    }
    
    private boolean isPrime(long num) {
        if (num < 2) {
            return false;
        }
        long sqrt = (long) Math.sqrt(num);
        for (long i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
