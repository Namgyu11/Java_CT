package codingTest.CT.CT18.ct01;

import java.util.*;

//24-02-09 (풀이) 다시 풀기 -- 우선순위 큐

class Solution {
  public int solution(int[] food) {
    PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

    for (int f : food) {
      queue.offer(f);
    }

    int answer = 0;

    while (!queue.isEmpty()) {
      if (queue.size() >= 2) {
        int head1 = queue.poll();
        int head2 = queue.poll();

        if (head1 > 1) {
          queue.offer(head1 - 1);
        }

        if (head2 > 1) {
          queue.offer(head2 - 1);
        }
      } else {
        int head = queue.poll();

        if (head > 1) {
          queue.offer(head - 1);
        }
      }

      answer++;
    }

    return answer;
  }
}
