package codingTest.CT.CT07.ct05;


//23-11-24(풀이)  - @@ @@다시 풀어보기@@ @@- 완전 탐색
public class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i];
            int sum = 0;  // 이 부분을 0으로 수정
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < min) min = nums[j];  // 부분 배열 중 가장 작은 원소 찾기
                sum += nums[j];                     // 부분 배열의 합 계산
                int score = sum * min;              // 점수 계산
                if (score > answer) answer = score; // 최대 점수 업데이트
            }
        }
        return answer;
    }

}
