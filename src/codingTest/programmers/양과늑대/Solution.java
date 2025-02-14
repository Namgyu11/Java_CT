package codingTest.programmers.양과늑대;

import java.util.*;

class Solution {
    static List<List<Integer>> tree;
    static int maxSheep = 0;

    public int solution(int[] info, int[][] edges) {
        int n = info.length;
        tree = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
        }

        List<Integer> availableNodes = new ArrayList<>();
        availableNodes.add(0);

        dfs(availableNodes, info, 0, 0, 0);

        return maxSheep;
    }

    private void dfs(List<Integer> nodes, int[] info, int sheep, int wolf, int currentNode) {
        if (info[currentNode] == 0) {
            sheep++;
        } else {
            wolf++;
        }

        if (wolf >= sheep) return;
        maxSheep = Math.max(maxSheep, sheep);

        List<Integer> nextNodes = new ArrayList<>(nodes);
        nextNodes.remove(Integer.valueOf(currentNode));
        nextNodes.addAll(tree.get(currentNode));

        for (int next : nextNodes) {
            dfs(nextNodes, info, sheep, wolf, next);
        }
    }
}

