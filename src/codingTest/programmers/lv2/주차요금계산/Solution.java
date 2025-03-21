package codingTest.programmers.lv2.주차요금계산;

import java.util.*;
import java.lang.Math;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> totalTime = new HashMap<>();
        Map<String, Integer> inTime = new HashMap<>();

        for(String record: records) {
            String[] parts = record.split(" ");
            String timeStr = parts[0];
            String car = parts[1];
            String status = parts[2];
            String[] timeParts = timeStr.split(":");
            int time = Integer.parseInt(timeParts[0]) * 60 + Integer.parseInt(timeParts[1]);

            if(status.equals("IN")) {
                inTime.put(car, time);
                totalTime.putIfAbsent(car, 0);
            } else {
                int start = inTime.get(car);
                int diff = time - start;
                totalTime.put(car, totalTime.get(car) + diff);
                inTime.remove(car);
            }
        }

        for(String car : inTime.keySet()) {
            int start = inTime.get(car);
            int diff = (23 * 60 + 59) - start;
            totalTime.put(car, totalTime.get(car) + diff);
        }
        List<String> cars = new ArrayList<>(totalTime.keySet());
        Collections.sort(cars);
        int[] answer = new int[cars.size()];
        int baseTime = fees[0], baseFee = fees[1], unitTime = fees[2], unitFee = fees[3];
        int idx = 0;

        for(String car : cars) {
            int time = totalTime.get(car);
            int fee = baseFee;
            if (time > baseTime) {
                fee += Math.ceil((time - baseTime) / (double) unitTime) * unitFee;
            }
            answer[idx++] = fee;
        }
        return answer;
    }
}
