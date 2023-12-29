package codingTest.CT.CT12.ct04;

import java.util.*;
//23-12-28(풀이) - 다시 풀기

public class Solution {
    public int[] solution(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int[] answer = new int[arr.length - k + 1];
        for (int i = 0; i < arr.length; i++) {
            if (maxHeap.size() <= minHeap.size()) maxHeap.offer(arr[i]);
            else minHeap.offer(arr[i]);

            if (maxHeap.size() > 0 && minHeap.size() > 0 && maxHeap.peek() > minHeap.peek()) {
                int temp = maxHeap.poll();
                maxHeap.offer(minHeap.poll());
                minHeap.offer(temp);
            }

            if (i >= k - 1) {
                answer[i - k + 1] = maxHeap.peek();
                if (arr[i - k + 1] <= maxHeap.peek()) maxHeap.remove(arr[i - k + 1]);
                else minHeap.remove(arr[i - k + 1]);
            }
        }
        return answer;
    }
}
