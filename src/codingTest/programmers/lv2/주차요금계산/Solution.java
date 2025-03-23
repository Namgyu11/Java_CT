package codingTest.programmers.lv2.주차요금계산;

import java.util.*;
import java.lang.Math;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> totalTime = new HashMap<>();
        Map<String, Integer> inTime = new HashMap<>();

        for(String record : records) {
            String[] parts = record.split(" ");
            String timeStr = parts[0];
            String car = parts[1];
            String status = parts[2];
            int hour = Integer.parseInt(timeStr.substring(0,2));
            int minute = Integer.parseInt(timeStr.substring(3));
            int time = hour * 60 + minute;

            if(status.equals("IN")) {
                inTime.put(car, time);
                totalTime.putIfAbsent(car, 0);
            } else {
                int in = inTime.get(car);
                totalTime.put(car, totalTime.get(car) + time - in);
                inTime.remove(car);
            }
        }

        for(String car : inTime.keySet()) {
            int in = inTime.get(car);
            totalTime.put(car, totalTime.get(car) + ((23 * 60 + 59) - in));
        }

        List<String> cars = new ArrayList<>(totalTime.keySet());
        Collections.sort(cars);

        int[] answer = new int[cars.size()];
        int baseTime = fees[0], baseFee = fees[1], unitTime = fees[2], unitFee = fees[3];

        for(int i = 0; i < cars.size(); i++){
            int time = totalTime.get(cars.get(i));
            int fee = baseFee;
            if(time > baseTime) fee += (int)Math.ceil((time - baseTime) / (double)unitTime) * unitFee;
            answer[i] = fee;
        }
        return answer;
    }
}
