package codingTest.programmers.표병합;

import java.util.*;

class Solution {
    static final int SIZE = 50;
    int[] parent;
    String[] cellVal;
    
    public String[] solution(String[] commands) {
        int total = SIZE * SIZE;
        parent = new int[total];
        cellVal = new String[total];
        for (int i = 0; i < total; i++) {
            parent[i] = i;
            cellVal[i] = "";
        }
        
        List<String> answerList = new ArrayList<>();
        
        for (String cmd : commands) {
            String[] parts = cmd.split(" ");
            String op = parts[0];
            
            if (op.equals("UPDATE")) {
                if (parts.length == 4) {
                    int r = Integer.parseInt(parts[1]);
                    int c = Integer.parseInt(parts[2]);
                    String value = parts[3];
                    int idx = getIndex(r, c);
                    int root = find(idx);
                    cellVal[root] = value;
                } else {
                    String value1 = parts[1];
                    String value2 = parts[2];
                    for (int i = 0; i < total; i++) {
                        if (parent[i] == i && cellVal[i].equals(value1)) {
                            cellVal[i] = value2;
                        }
                    }
                }
            } else if (op.equals("MERGE")) {
                int r1 = Integer.parseInt(parts[1]);
                int c1 = Integer.parseInt(parts[2]);
                int r2 = Integer.parseInt(parts[3]);
                int c2 = Integer.parseInt(parts[4]);
                int idx1 = getIndex(r1, c1);
                int idx2 = getIndex(r2, c2);
                if (find(idx1) == find(idx2)) {
                    continue;
                }
                merge(idx1, idx2);
            } else if (op.equals("UNMERGE")) {
                int r = Integer.parseInt(parts[1]);
                int c = Integer.parseInt(parts[2]);
                int idx = getIndex(r, c);
                unmerge(idx);
            } else if (op.equals("PRINT")) {
                int r = Integer.parseInt(parts[1]);
                int c = Integer.parseInt(parts[2]);
                int idx = getIndex(r, c);
                int root = find(idx);
                String val = cellVal[root];
                answerList.add(val.equals("") ? "EMPTY" : val);
            }
        }
        
        return answerList.toArray(new String[0]);
    }
    
    private int getIndex(int r, int c) {
        return (r - 1) * SIZE + (c - 1);
    }
    
    private int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    private void merge(int idx1, int idx2) {
        int root1 = find(idx1);
        int root2 = find(idx2);
        if (root1 == root2) {
            return;
        }
        if (cellVal[root1].equals("") && !cellVal[root2].equals("")) {
            cellVal[root1] = cellVal[root2];
        }
        parent[root2] = root1;
    }
    
    private void unmerge(int idx) {
        int root = find(idx);
        String savedVal = cellVal[root];
        int total = SIZE * SIZE;
        for (int i = 0; i < total; i++) {
            if (find(i) == root) {
                parent[i] = i;
                cellVal[i] = "";
            }
        }
        cellVal[idx] = savedVal;
    }
}
