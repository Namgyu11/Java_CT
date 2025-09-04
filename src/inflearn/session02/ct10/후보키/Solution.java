package inflearn.session02.ct10.후보키;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int solution(String[][] relation) {
        int rowCount = relation.length;
        int colCount = relation[0].length;
        List<Integer> candidates = new ArrayList<>();
        
        int maxMask = 1 << colCount;
        for (int mask = 1; mask < maxMask; mask++) {
            boolean minimal = true;
            for (int cand : candidates) {
                if ((cand & mask) == cand) {
                    minimal = false;
                    break;
                }
            }
            if (!minimal) {
                continue;
            }
            
            Set<String> seen = new HashSet<>();
            for (int r = 0; r < rowCount; r++) {
                StringBuilder key = new StringBuilder();
                for (int c = 0; c < colCount; c++) {
                    if ((mask & (1 << c)) != 0) {
                        key.append(relation[r][c]).append('|');
                    }
                }
                seen.add(key.toString());
            }
            if (seen.size() == rowCount) {
                candidates.add(mask);
            }
        }
        
        return candidates.size();
    }
}
