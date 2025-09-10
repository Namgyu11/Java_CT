package inflearn.session02.ct07.쿠키_구입;

class Solution {
    public int solution(int[] cookie) {
        int n = cookie.length;
        int answer = 0;
        for (int m = 0; m < n - 1; m++) {
            int i = m, j = m + 1;
            int leftSum = cookie[i], rightSum = cookie[j];
            while (i >= 0 && j < n) {
                if (leftSum == rightSum) {
                    answer = Math.max(answer, leftSum);
                    i--;
                    if (i >= 0) {
                        leftSum += cookie[i];
                    }
                    j++;
                    if (j < n) {
                        rightSum += cookie[j];
                    }
                } else if (leftSum < rightSum) {
                    i--;
                    if (i >= 0) {
                        leftSum += cookie[i];
                    }
                } else {
                    j++;
                    if (j < n) {
                        rightSum += cookie[j];
                    }
                }
            }
        }
        return answer;
    }
}
