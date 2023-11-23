package codingTest.CT.CT06.ct04;

import java.util.*;
//23-11-17(풀이) - 다시 풀기
class Solution {
    public int[] solution(int[] arr, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int[] answer = new int[arr.length - k + 1];

        for (int i = 0; i < arr.length; i++) {
            // 현재 요소보다 작은 요소들을 deque에서 제거합니다.
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.pollLast();
            }
            // 현재 요소의 인덱스를 deque에 추가합니다.
            deque.offerLast(i);
            // deque의 첫 번째 요소가 윈도우를 벗어나면 제거합니다.
            if (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            // 현재 윈도우의 최대값을 answer에 추가합니다.
            if (i >= k - 1) {
                answer[i - k + 1] = arr[deque.peekFirst()];
            }
        }

        return answer;
    }

    public static void main(String[] args) {

    }
}
