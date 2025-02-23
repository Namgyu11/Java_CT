package codingTest.programmers.lv3.등산코스정하기;

import java.util.*;

class Solution {
    static class Edge {
        int to, weight;
        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    
    static class Node implements Comparable<Node> {
        int id, intensity;
        public Node(int id, int intensity) {
            this.id = id;
            this.intensity = intensity;
        }
        public int compareTo(Node other) {
            return this.intensity - other.intensity;
        }
    }
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] path : paths) {
            int a = path[0], b = path[1], w = path[2];
            graph.get(a).add(new Edge(b, w));
            graph.get(b).add(new Edge(a, w));
        }
        
        boolean[] isGate = new boolean[n+1];
        for (int g : gates) {
            isGate[g] = true;
        }
        boolean[] isSummit = new boolean[n+1];
        for (int s : summits) {
            isSummit[s] = true;
        }
        
        int[] intensity = new int[n+1];
        Arrays.fill(intensity, Integer.MAX_VALUE);
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int g : gates) {
            intensity[g] = 0;
            pq.offer(new Node(g, 0));
        }
        
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int currId = curr.id;
            int currIntensity = curr.intensity;
            
            if (currIntensity > intensity[currId]) {
                continue;
            }
            
            if (isSummit[currId]) {
                continue;
            }
            
            for (Edge edge : graph.get(currId)) {
                int nextId = edge.to;
                if (isGate[nextId]) {
                    continue;
                }
                
                int nextIntensity = Math.max(currIntensity, edge.weight);
                if (nextIntensity < intensity[nextId]) {
                    intensity[nextId] = nextIntensity;
                    pq.offer(new Node(nextId, nextIntensity));
                }
            }
        }
        
        int answerSummit = 0;
        int answerIntensity = Integer.MAX_VALUE;
        Arrays.sort(summits);
        for (int summit : summits) {
            if (intensity[summit] < answerIntensity) {
                answerIntensity = intensity[summit];
                answerSummit = summit;
            }
        }
        
        return new int[]{answerSummit, answerIntensity};
    }
}
