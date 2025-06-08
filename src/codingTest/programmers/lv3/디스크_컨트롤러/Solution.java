package codingTest.programmers.lv3.디스크_컨트롤러;

import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int n = jobs.length;
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = jobs[i][0];
            arr[i][1] = jobs[i][1]; 
            arr[i][2] = i;          
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        
       
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[1] != b[1]) {
                    return a[1] - b[1];
                }
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                }
                return a[2] - b[2];
            }
        );
        
        int time = 0;
        int idx = 0;
        long totalTurnaround = 0;
        int processed = 0;
        
        while (processed < n) {
            while (idx < n && arr[idx][0] <= time) {
                pq.offer(arr[idx++]);
            }
            if (pq.isEmpty()) {
                time = arr[idx][0];
                continue;
            }
            int[] job = pq.poll();
            time += job[1];
            totalTurnaround += (time - job[0]);
            processed++;
        }
        
        return (int)(totalTurnaround / n);
    }
}
