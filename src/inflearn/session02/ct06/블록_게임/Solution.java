package inflearn.session02.ct06.블록_게임;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

class Solution {
    static class Block {
        int id, minR = Integer.MAX_VALUE, maxR = -1, minC = Integer.MAX_VALUE, maxC = -1;
        List<int[]> cells = new ArrayList<>();
        List<int[]> holes = new ArrayList<>();
        Block(int id) { this.id = id; }
        void addCell(int r, int c) {
            cells.add(new int[]{r, c});
            minR = Math.min(minR, r);
            maxR = Math.max(maxR, r);
            minC = Math.min(minC, c);
            maxC = Math.max(maxC, c);
        }
        void findHoles(int[][] board) {
            for (int r = minR; r <= maxR; r++) {
                for (int c = minC; c <= maxC; c++) {
                    if (board[r][c] == 0) {
                        holes.add(new int[]{r, c});
                    }
                }
            }
        }
    }
    
    public int solution(int[][] board) {
        int N = board.length;
        Map<Integer, Block> blocks = new HashMap<>();
        
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                int v = board[r][c];
                if (v > 0) {
                    blocks.computeIfAbsent(v, k -> new Block(k)).addCell(r, c);
                }
            }
        }
        for (Block blk : blocks.values()) {
            blk.findHoles(board);
        }
        TreeSet<Integer>[] colSets = new TreeSet[N];
        for (int c = 0; c < N; c++) {
            colSets[c] = new TreeSet<>();
            for (int r = 0; r < N; r++) {
                if (board[r][c] != 0) {
                    colSets[c].add(r);
                }
            }
        }
        
        int removed = 0;
        boolean progress = true;
        Set<Integer> ids = new HashSet<>(blocks.keySet());
        
        while (progress) {
            progress = false;
            Iterator<Integer> it = ids.iterator();
            while (it.hasNext()) {
                Block blk = blocks.get(it.next());
                if (canRemove(blk, colSets)) {
                    for (int[] rc : blk.cells) {
                        board[rc[0]][rc[1]] = 0;
                        colSets[rc[1]].remove(rc[0]);
                    }
                    it.remove();
                    removed++;
                    progress = true;
                }
            }
        }
        return removed;
    }
    
    private boolean canRemove(Block blk, TreeSet<Integer>[] colSets) {
        for (int[] hole : blk.holes) {
            int r = hole[0], c = hole[1];
            Integer above = colSets[c].lower(r);
            if (above != null) {
                return false;
            }
        }
        return true;
    }
}
