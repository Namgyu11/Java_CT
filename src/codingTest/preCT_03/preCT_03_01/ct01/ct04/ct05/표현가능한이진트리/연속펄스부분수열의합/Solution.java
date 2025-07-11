package codingTest.preCT_03.preCT_03_01.ct01.ct04.ct05.표현가능한이진트리.연속펄스부분수열의합;


class Solution {
    public long solution(int[] sequence) {
        int N = sequence.length;
        long[] pulse1 = new long[N];
        long[] pulse2 = new long[N];

        for (int i = 0; i < N; i++) {
            pulse1[i] = sequence[i] * (i % 2 == 0 ? 1 : -1);
            pulse2[i] = sequence[i] * (i % 2 == 0 ? -1 : 1);
        }

        return Math.max(maxSubarraySum(pulse1), maxSubarraySum(pulse2));
    }

    private static long maxSubarraySum(long[] arr) {
        long maxSum = arr[0], currentSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
