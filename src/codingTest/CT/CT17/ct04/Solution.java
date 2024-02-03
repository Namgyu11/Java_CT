package codingTest.CT.CT17.ct04;


import java.util.*;
//24-02-01 (풀이) 다시 풀기 - 그리디

public class Solution {

  public int solution(int dest, int start, int[] station, int[] fuel) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    int answer = 0, currentFuel = start, idx = 0;

    for (int i = 0; i < dest; i++) {
      // 현재 위치에 연료통이 있는지 확인
      while (idx < station.length && station[idx] == i) {
        pq.offer(fuel[idx]);
        idx++;
      }

      // 연료가 떨어지면 우선순위 큐에서 가장 큰 연료 양을 꺼내 사용
      if (currentFuel == 0) {
        if (pq.isEmpty()) {
          return -1;
        }
        currentFuel += pq.poll();
        answer++;
      }

      currentFuel--;
    }

    return answer;
  }
}
