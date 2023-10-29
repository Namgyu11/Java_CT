package codingTest.CT.CT03.ct02;

//23-10-26(풀이) -- 다시 풀기

import java.util.*;

public class Solution {
    int answer = Integer.MAX_VALUE;

    public int solution(int[] numbers, int target) {
        int max = 10001; // 표현할 수 없는 경우를 위해 임의의 큰 수로 설정
        int[] dp = new int[target + 1];

        // dp 배열 초기화
        Arrays.fill(dp, max);
        dp[0] = 0;

        // numbers에 있는 각 숫자에 대해
        for (int num : numbers) {
            for (int i = num; i <= target; i++) {
                // 숫자를 더하거나 곱했을 때 target을 넘지 않는 경우
                dp[i] = Math.min(dp[i], dp[i - num] + 1);
                if (i % num == 0) {
                    dp[i] = Math.min(dp[i], dp[i / num] + 1);
                }
            }
        }

        // 결과 반환
        return dp[target] >= max ? -1 : dp[target];
    }

    public static void main(String[] args) {

        int[] numbers = {1,4,2};
        int target = 12;
        Solution solution = new Solution();
        System.out.println(solution.solution(numbers, target));
    }
}
