package codingTest.CT.CT_month_05.ct03;

import java.util.*;

//22-02-17(풀이) 다익스트라 - 순열
class Solution {
  static final int INF = (int) 1e9;
  int N, M;
  List<List<Node>> graph;
  int[][] dist;

  public int solution(int N, int M, int[][] edges, int[] points) {
    this.N = N;
    this.M = M;
    graph = new ArrayList<>();
    for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

    for (int[] edge : edges) {
      int a = edge[0], b = edge[1], c = edge[2];
      graph.get(a).add(new Node(b, c));
      graph.get(b).add(new Node(a, c));
    }

    // 모든 노드간의 최단 거리 계산
    dist = new int[N+1][N+1];
    for (int i = 1; i <= N; i++) {
      Arrays.fill(dist[i], INF);
      dijkstra(i);
    }

    // 거점 노드들 간의 모든 경로를 순열을 이용해 생성
    int[] perm = new int[]{points[0], points[1], points[2]};
    int answer = INF;
    do {
      int current = dist[1][perm[0]] + dist[perm[0]][perm[1]] + dist[perm[1]][perm[2]] + dist[perm[2]][N];
      answer = Math.min(answer, current);
    } while (next_permutation(perm));

    return answer >= INF ? -1 : answer;
  }

  // 다익스트라 알고리즘
  private void dijkstra(int start) {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.offer(new Node(start, 0));
    dist[start][start] = 0;

    while (!pq.isEmpty()) {
      Node node = pq.poll();
      int now = node.index, nowCost = node.distance;

      if (nowCost > dist[start][now]) continue;

      for (Node next : graph.get(now)) {
        int cost = nowCost + next.distance;
        if (cost < dist[start][next.index]) {
          dist[start][next.index] = cost;
          pq.offer(new Node(next.index, cost));
        }
      }
    }
  }

  // 순열 생성
  private boolean next_permutation(int[] a) {
    int i = a.length - 1;
    while (i > 0 && a[i-1] >= a[i]) i--;
    if (i <= 0) return false;

    int j = a.length - 1;
    while (a[j] <= a[i-1]) j--;

    swap(a, i-1, j);

    j = a.length - 1;
    while (i < j) swap(a, i++, j--);

    return true;
  }

  private void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  static class Node implements Comparable<Node> {
    int index, distance;

    Node(int index, int distance) {
      this.index = index;
      this.distance = distance;
    }

    @Override
    public int compareTo(Node o) {
      return Integer.compare(this.distance, o.distance);
    }
  }
}
