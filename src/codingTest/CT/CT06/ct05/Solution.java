package codingTest.CT.CT06.ct05;
//23-11-17(풀이) - 다시 풀기 DP,Greedy 혼합
public class Solution {
    public static int[] solution(int[] scores) {
        int n = scores.length;
        int[] answer = new int[n];

        // 모든 학생에게는 최소 1개의 초코렛을 나눠줍니다.
        for (int i = 0; i < n; i++) {
            answer[i] = 1;
        }

        // 왼쪽에서 오른쪽으로 순회합니다.
        for (int i = 1; i < n; i++) {
            // 왼쪽 학생보다 점수가 높다면 왼쪽 학생보다 초코렛을 1개 더 받습니다.
            if (scores[i] > scores[i - 1]) {
                answer[i] = answer[i - 1] + 1;
            }
        }

        // 오른쪽에서 왼쪽으로 순회합니다.
        for (int i = n - 2; i >= 0; i--) {
            // 오른쪽 학생보다 점수가 높고, 현재 받은 초코렛의 수가 오른쪽 학생보다 적다면
            // 오른쪽 학생보다 초코렛을 1개 더 받습니다.
            if (scores[i] > scores[i + 1] && answer[i] <= answer[i + 1]) {
                answer[i] = answer[i + 1] + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] scores = {1, 3, 5, 4, 5, 5, 5, 1};
        System.out.println(solution(scores));
    }
}
