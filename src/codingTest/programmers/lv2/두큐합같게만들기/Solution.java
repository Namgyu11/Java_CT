package codingTest.programmers.lv2.두큐합같게만들기;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0, sum2 = 0;
        int n = queue1.length;

        for (int i = 0; i < n; i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];
        }

        long total = sum1 + sum2;

        if (total % 2 != 0) {
            return -1;
        }

        long target = total / 2;

        int[] arr = new int[n * 2];
        System.arraycopy(queue1, 0, arr, 0, n);
        System.arraycopy(queue2, 0, arr, n, n);

        int i = 0, j = n, count = 0, limit = n * 3;

        while (count <= limit && i < n * 2 && j < n * 2) {
            if (sum1 == target) {
                return count;
            }
            if (sum1 > target) {
                sum1 -= arr[i++];
            } else {
                sum1 += arr[j++];
            }
            count++;
        }
        return -1;
    }
}
