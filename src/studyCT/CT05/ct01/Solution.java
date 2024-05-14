package studyCT.CT05.ct01;

import java.util.*;

class Solution {

  public int networkDelayTime(int[][] times, int n, int k) {
    // 그래프를 만들어 각 노드에서 다른 노드로 가는 시간을 저장.
    Map<Integer, List<int[]>> graph = new HashMap<>();
    for (int[] time : times) {
      graph.computeIfAbsent(time[0], x -> new ArrayList<>()).add(new int[]{time[1], time[2]});
    }

    // 우선순위 큐를 사용하여 가장 짧은 거리부터 처리.
    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
    // 시작 노드와 거리(0)를 큐에 추가.
    pq.offer(new int[]{k, 0});

    // 각 노드까지의 최단 거리를 저장할 맵.
    Map<Integer, Integer> distance = new HashMap<>();

    // 우선순위 큐가 비어있지 않는 동안 반복.
    while (!pq.isEmpty()) {
      // 현재 노드와 거리를 꺼냄.
      int[] current = pq.poll();
      int node = current[0];
      int dist = current[1];

      // 이미 방문한 노드라면 무시.
      if (distance.containsKey(node)) {
        continue;
      }
      // 최단 거리를 갱신.
      distance.put(node, dist);

      // 현재 노드에서 갈 수 있는 모든 노드에 대해 처리.
      if (graph.containsKey(node)) {
        for (int[] edge : graph.get(node)) {
          int next = edge[0];
          int d = edge[1] + dist;
          // 아직 방문하지 않은 노드라면, 우선순위 큐에 추가.
          if (!distance.containsKey(next)) {
            pq.offer(new int[]{next, d});
          }
        }
      }
    }

    // 모든 노드를 방문했는지 확인. 방문하지 않은 노드가 있다면 -1을 반환.
    if (distance.size() != n) {
      return -1;
    }
    // 모든 노드를 방문하는데 걸린 최대 시간을 반환.
    return Collections.max(distance.values());
  }
}
