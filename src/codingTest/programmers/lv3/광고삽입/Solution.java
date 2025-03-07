package codingTest.programmers.lv3.광고삽입;

import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int playSec = timeToSec(play_time);
        int advSec = timeToSec(adv_time);
        long[] timeline = new long[playSec + 1];
        
        for (String log : logs) {
            String[] parts = log.split("-");
            int start = timeToSec(parts[0]);
            int end = timeToSec(parts[1]);
            timeline[start] += 1;
            if (end <= playSec) {
                timeline[end] -= 1;
            }
        }
        
        for (int i = 1; i <= playSec; i++) {
            timeline[i] += timeline[i - 1];
        }
        
        long[] cumulative = new long[playSec + 1];
        cumulative[0] = timeline[0];
        for (int i = 1; i <= playSec; i++) {
            cumulative[i] = cumulative[i - 1] + timeline[i];
        }
        
        long maxView = cumulative[advSec - 1];
        int answerStart = 0;
        
        for (int start = 1; start <= playSec - advSec; start++) {
            long viewTime = cumulative[start + advSec - 1] - cumulative[start - 1];
            if (viewTime > maxView) {
                maxView = viewTime;
                answerStart = start;
            }
        }
        
        return secToTime(answerStart);
    }
    
    private int timeToSec(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        int seconds = Integer.parseInt(parts[2]);
        return hours * 3600 + minutes * 60 + seconds;
    }
    
    private String secToTime(int sec) {
        int hours = sec / 3600;
        sec %= 3600;
        int minutes = sec / 60;
        int seconds = sec % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
