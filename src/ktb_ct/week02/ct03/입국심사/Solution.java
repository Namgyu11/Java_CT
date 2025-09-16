package ktb_ct.week02.ct03.입국심사;

class Solution {
    public long solution(long n, int[] times) {
        long low = 1;
        long high = 0;
        for (int t : times) {
            high = Math.max(high, t);
        }
        high *= n;  
        
        long answer = high;
        while (low <= high) {
            long mid = (low + high) >>> 1;
            if (canProcessAll(n, times, mid)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }
    
    private boolean canProcessAll(long n, int[] times, long t) {
        long count = 0;
        for (int time : times) {
            count += t / time;
            if (count >= n) {
                return true;
            }
        }
        return false;
    }
}
