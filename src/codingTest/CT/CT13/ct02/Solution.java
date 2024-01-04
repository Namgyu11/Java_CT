package codingTest.CT.CT13.ct02;

import java.util.Arrays;


//24-01-04(풀이) - 다시 풀기 - 투포인터
public class Solution {
    public static int solution(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        int answer = arr[0] + arr[1] + arr[2];
        for (int i = 0; i < n - 2; i++) {
            int start = i + 1, end = n - 1;
            while (start < end) {
                int sum = arr[i] + arr[start] + arr[end];
                if (Math.abs(target - answer) > Math.abs(target - sum) ||
                        (Math.abs(target - answer) == Math.abs(target - sum) && sum < answer)) {
                    answer = sum;
                }
                if (sum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}
