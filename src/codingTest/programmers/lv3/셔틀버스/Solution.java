package codingTest.programmers.lv3.셔틀버스;

import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int[] crew = new int[timetable.length];
        for (int i = 0; i < timetable.length; i++) {
            String[] hm = timetable[i].split(":");
            crew[i] = Integer.parseInt(hm[0]) * 60 + Integer.parseInt(hm[1]);
        }
        Arrays.sort(crew);
        int idx = 0; 

        int firstBus = 9 * 60; 
        int time = firstBus;
        int lastDeparture = 0;

        for (int i = 0; i < n; i++) {
            int capacity = m;
            int boarded = 0;
            while (boarded < m && idx < crew.length && crew[idx] <= time) {
                boarded++;
                idx++;
            }
            if (i == n - 1) {
                if (boarded < m) {
                    lastDeparture = time;
                } else {
                    lastDeparture = crew[idx - 1] - 1;
                }
            }
            time += t; 
        }

        int hh = lastDeparture / 60;
        int mm = lastDeparture % 60;
        return String.format("%02d:%02d", hh, mm);
    }
}
