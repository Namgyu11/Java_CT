package codingTest.CT.CT05.ct04;

import java.util.Arrays;

//23-11-10 (풀이) @@@@@@@@ 다시 풀기 @@@@@@@@@

class Solution {
    public int solution(int N, int[] branches) {
        Arrays.sort(branches);
        long left = 1, right = branches[branches.length - 1];
        int answer = -1;

        while (left <= right) {
            long mid = (left + right) / 2;

            long sum = 0;
            for (int branch : branches) {
                sum += branch / mid;
            }

            if (sum >= N) {
                answer = (int) mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }
}
