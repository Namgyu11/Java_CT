package codingTest.programmers.lv3.단속카메라;

import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));
        
        int cameras = 0;
        int lastCamPos = Integer.MIN_VALUE;
        
        for (int[] route : routes) {
            int entry = route[0];
            int exit = route[1];
            if (entry > lastCamPos) {
                cameras++;
                lastCamPos = exit; 
            }
        }
        
        return cameras;
    }
}
