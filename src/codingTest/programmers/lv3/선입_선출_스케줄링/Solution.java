package codingTest.programmers.lv3.선입_선출_스케줄링;

class Solution {
    public int solution(int n, int[] cores) {
        int m = cores.length;
        if (n <= m) {
            return n;
        }
        
        long left = 0, right = 0;
        for (int c : cores) {
            right = Math.max(right, (long)c * n);
        }
        
        long time = right;
        while (left <= right) {
            long mid = (left + right) / 2;
            long tasks = tasksByTime(cores, mid);
            if (tasks >= n) {
                time = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        long tasksBefore = tasksByTime(cores, time - 1);
      
        for (int i = 0; i < m; i++) {
            if (time % cores[i] == 0) {
                tasksBefore++;
                if (tasksBefore == n) {
                    return i + 1; 
                }
            }
        }
        return -1;
    }
    
    private long tasksByTime(int[] cores, long T) {
        long sum = 0;
        for (int c : cores) {
            sum += T / c;
        }
        return sum + cores.length; 
    }
}
