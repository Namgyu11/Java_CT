package studyCT.CT03.ct02;

public class Solution {

  int[] gInfo; // 0: 양, 1: 늑대
  int[][] gEdegs; // 간선 정보
  int maxSheepCnt = 0; // 최대 양의 수

  public int solution(int[] info, int[][] edges) {
    gInfo = info; // 각 노드의 정보
    gEdegs = edges; // 간선 정보
    boolean[] initVisited = new boolean[info.length]; // 방문 여부
    dfs(0, initVisited, 0, 0); // 0번 노드부터 시작
    return maxSheepCnt; // 최대 양의 수 반환
  }

  public void dfs(int idx, boolean[] visited, int sheepCnt, int wolfCnt) {
    visited[idx] = true; // 방문한 노드는 true 로 변경
    if (gInfo[idx] == 0) { // 양인 경우
      sheepCnt++;// 양의 수 증가
      if (sheepCnt > maxSheepCnt) { // 최대 양의 수 갱신
        maxSheepCnt = sheepCnt;
      }
    } else {
      wolfCnt++;// 늑대의 수 증가
    }

    if (sheepCnt <= wolfCnt) { // 양의 수가 늑대의 수보다 작거나 같으면 종료
      return;
    }

    for (int[] edge : gEdegs) { // 간선 정보를 순회
      if (visited[edge[0]] && !visited[edge[1]]) { // 방문한 노드와 방문하지 않은 노드인 경우
        boolean[] newVisited = new boolean[visited.length];// 방문 여부를 복사
        for (int i = 0; i < visited.length; i++) {
          newVisited[i] = visited[i];
        }
        dfs(edge[1], newVisited, sheepCnt, wolfCnt); // 다음 노드로 이동
      }
    }
  }

}

