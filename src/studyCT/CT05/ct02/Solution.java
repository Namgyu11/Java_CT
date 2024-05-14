package studyCT.CT05.ct02;

import java.util.*;

class Solution {
  public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

    // 그래프를 생성합니다. 각 노드에서 연결된 노드와 그 확률을 저장.
    Map<Integer, List<int[]>> graph = new HashMap<>();
    for (int i = 0; i < edges.length; i++) {
      int[] edge = edges[i];
      graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(new int[]{edge[1], i});
      graph.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(new int[]{edge[0], i});
    }

    // 최대 확률을 저장하기 위한 배열입니다. 모든 값을 0으로 초기화.
    double[] prob = new double[n];
    Arrays.fill(prob, 0.0);
    prob[start] = 1.0; // 시작 노드의 확률은 1.

    // 우선순위 큐를 사용하여 확률이 높은 경로부터 탐색.
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Double.compare(prob[b[0]], prob[a[0]]));
    pq.offer(new int[]{start, -1}); // 시작 노드를 큐에 추가.

    while (!pq.isEmpty()) {
      int[] current = pq.poll();
      int currentNode = current[0];

      if (currentNode == end) {
        return prob[end];
      }

      for (int[] next : graph.getOrDefault(currentNode, Collections.emptyList())) {
        int nextNode = next[0];
        int edgeIndex = next[1];
        double nextProb = prob[currentNode] * succProb[edgeIndex];

        // 다음 노드로 가는 확률이 현재 저장된 확률보다 높으면 업데이트하고 큐에 추가.
        if (nextProb > prob[nextNode]) {
          prob[nextNode] = nextProb;
          pq.offer(new int[]{nextNode, edgeIndex});
        }
      }
    }

    // 종료 노드에 도달할 수 없으면 0을 반환합니다.

    return 0.0;

  }
}

