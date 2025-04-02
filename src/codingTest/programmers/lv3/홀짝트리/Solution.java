package codingTest.programmers.lv3.홀짝트리;

import java.util.*;
class Solution {
    public int[] solution(int[] nodes, int[][] edges) {
        int max = 0;
        for (int v : nodes) {
            if (v > max) {
                max = v;
            }
        }
        boolean[] present = new boolean[max+1];

        for (int v : nodes) {
            present[v] = true;
        }
        ArrayList<Integer>[] graph = new ArrayList[max+1];

        for (int i = 0; i <= max; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            if(present[a] && present[b]) {
                graph[a].add(b);
                graph[b].add(a);
            }
        }
        boolean[] visited = new boolean[max+1];

        int cntHoljjak = 0, cntReverse = 0;
        for (int v : nodes) {
            if (!visited[v]) {
                ArrayList<Integer> comp = new ArrayList<>();
                Queue<Integer> q = new LinkedList<>();
                q.offer(v);
                visited[v] = true;
                while(!q.isEmpty()){
                    int cur = q.poll();
                    comp.add(cur);
                    for (int nb : graph[cur]) {
                        if(!visited[nb]) {
                            visited[nb] = true;
                            q.offer(nb);
                        }
                    }
                }
                if(comp.size() == 1) {
                    int u = comp.get(0);
                    if (u % 2 == 0) {
                        cntHoljjak++;
                    }
                    if (u % 2 == 1) {
                        cntReverse++;
                    }
                } else {
                    int rootCandidateCount = 0;
                    for (int u : comp) {
                        int deg = graph[u].size();
                        if(u % 2 == 1) {
                            if (deg % 2 == 1) {
                                rootCandidateCount++;
                            }
                        } else {
                            if (deg % 2 == 0) {
                                rootCandidateCount++;
                            }
                        }
                    }
                    if (rootCandidateCount == 1) {
                        cntHoljjak++;
                    }
                    int rootCandidateCountRev = 0;
                    for (int u : comp) {
                        int deg = graph[u].size();
                        if(u % 2 == 1) {
                            if (deg % 2 == 0) {
                                rootCandidateCountRev++;
                            }
                        } else {
                            if (deg % 2 == 1) {
                                rootCandidateCountRev++;
                            }
                        }
                    }
                    if (rootCandidateCountRev == 1) {
                        cntReverse++;
                    }
                }
            }
        }
        return new int[]{cntHoljjak, cntReverse};
    }
}
