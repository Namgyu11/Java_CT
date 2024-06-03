package studyCT.CT08;

import java.util.*;

public class Solution {
      public static int minInfectedComputers(int n, int[][] edges) {
            List<List<Integer>> tree = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                  tree.add(new ArrayList<>());
            }

            // 트리 구조 생성
            for (int[] edge : edges) {
                  int parent = edge[0];
                  int child = edge[1];
                  tree.get(parent).add(child);
            }

            return dfs(tree, 0);
      }

      // DFS를 사용하여 감염된 노드 수를 최소화
      private static int dfs(List<List<Integer>> tree, int node) {
            int totalInfected = 0;

            for (int child : tree.get(node)) {
                  totalInfected += dfs(tree, child);
            }

            // 자식 노드를 자르거나 전체 서브트리를 감염시키는 것 중 최적의 선택
            if (totalInfected == 0) {
                  return 1;
            }
            return Math.min(1, totalInfected);
      }

      public static void main(String[] args) {
            // 입출력 예 #1
            int n1 = 19;
            int[][] edges1 = {
                    {0, 1}, {0, 2}, {0, 3}, {1, 4}, {1, 5}, {2, 6}, {3, 7}, {3, 8}, {3, 9},
                    {4, 10}, {4, 11}, {5, 12}, {5, 13}, {6, 14}, {6, 15}, {6, 16}, {8, 17}, {8, 18}
            };
            System.out.println(minInfectedComputers(n1, edges1)); // 7

            // 입출력 예 #2
            int n2 = 14;
            int[][] edges2 = {
                    {0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}, {2, 7}, {3, 8}, {3, 9}, {3, 10},
                    {4, 11}, {4, 12}, {4, 13}
            };
            System.out.println(minInfectedComputers(n2, edges2)); // 4

            // 입출력 예 #3
            int n3 = 10;
            int[][] edges3 = {
                    {0, 1}, {0, 2}, {1, 3}, {2, 4}, {2, 5}, {2, 6}, {3, 7}, {3, 8}, {3, 9}
            };
            System.out.println(minInfectedComputers(n3, edges3)); // 2
      }
}
