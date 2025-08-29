package inflearn.session03.ct02.택배배달과수거하기;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int deliverIdx = n - 1;
        int pickupIdx = n - 1;
        
        while (deliverIdx >= 0 && deliveries[deliverIdx] == 0) {
            deliverIdx--;
        }
        while (pickupIdx >= 0 && pickups[pickupIdx] == 0) {
            pickupIdx--;
        }
        
        while (deliverIdx >= 0 || pickupIdx >= 0) {
            int tripDistance = Math.max(deliverIdx, pickupIdx) + 1;
            answer += (long) tripDistance * 2;
            
            int capRemaining = cap;
            for (int i = deliverIdx; i >= 0 && capRemaining > 0; i--) {
                if (deliveries[i] == 0) {
                    continue;
                }
                if (deliveries[i] <= capRemaining) {
                    capRemaining -= deliveries[i];
                    deliveries[i] = 0;
                } else {
                    deliveries[i] -= capRemaining;
                    capRemaining = 0;
                }
            }
            while (deliverIdx >= 0 && deliveries[deliverIdx] == 0) {
                deliverIdx--;
            }
            
            capRemaining = cap;
            for (int i = pickupIdx; i >= 0 && capRemaining > 0; i--) {
                if (pickups[i] == 0) {
                    continue;
                }
                if (pickups[i] <= capRemaining) {
                    capRemaining -= pickups[i];
                    pickups[i] = 0;
                } else {
                    pickups[i] -= capRemaining;
                    capRemaining = 0;
                }
            }
            while (pickupIdx >= 0 && pickups[pickupIdx] == 0) {
                pickupIdx--;
            }
        }
        
        return answer;
    }
}
