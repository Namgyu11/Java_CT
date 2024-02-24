package codingTest.CT.CT20.ct03;
import java.util.*;

//24-02-23 (풀이) 다시 풀기 -- 그리디
public class Solution {

  public int solution(int[][] activity) {
    Arrays.sort(activity, (a, b) -> a[0] - b[0]); // 활동을 시작 시간에 따라 정렬

    PriorityQueue<Integer> queue = new PriorityQueue<>(); // 분신의 끝나는 시간을 저장하는 우선순위 큐
    queue.offer(activity[0][1]); // 첫 번째 활동을 수행하는 분신의 끝나는 시간을 추가

    for (int i = 1; i < activity.length; i++) {
      if (activity[i][0] >= queue.peek()) { // 현재 활동이 가장 빨리 끝나는 분신의 끝나는 시간 이후에 시작한다면
        queue.poll(); // 가장 빨리 끝나는 분신의 스케줄을 변경
      }
      queue.offer(activity[i][1]); // 현재 활동을 수행하는 분신의 끝나는 시간을 추가
    }

    return queue.size(); // 필요한 분신의 수는 우선순위 큐의 크기와 같음
  }
}
