package codingTest.CT.CT15.ct05;

public class Solution {
    public int solution(int[] nums) {
        int n = nums.length / 3;

        // 누적합을 구합니다.
        // 누적합을 구하는 이유는 범위의 합을 쉽게 구하기 위해서입니다.
        // cumSum[i] - cumSum[j]를 구하면, 이것은
        // nums[j+1], nums[j+2], ... , nums[i]의 총합이 됩니다.
        int[] cumSum = new int[nums.length];
        cumSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cumSum[i] = cumSum[i-1] + nums[i];
        }

        int minDiff = Integer.MAX_VALUE;
        int sumFirst, sumSecond;

        // 1. 제거하는 배열이 sumFirst 구간과 겹치는 경우
        sumSecond = cumSum[3*n - 1] - cumSum[2*n - 1];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                sumFirst = cumSum[2*n-1] - cumSum[n-1];
            } else {
                sumFirst = cumSum[i-1] + cumSum[2*n-1] - cumSum[n-1+i];
            }

            int diff = sumFirst - sumSecond;
            minDiff = Math.min(minDiff, diff);
        }

        // 2. 제거하는 배열이 sumSecond 구간과 겹치는 경우
        // i < n+1인 이유는, sumFirst와 sumSecond 둘 모두와 겹치지 않는 경우도 상정
        sumFirst = cumSum[n-1];
        for (int i = 0; i < n+1; i++) {
            sumSecond = cumSum[2*n-1-i] - cumSum[n-1] + cumSum[3*n-1] - cumSum[3*n-1-i];
            int diff = sumFirst - sumSecond;
            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }

}
