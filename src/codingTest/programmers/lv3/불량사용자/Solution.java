package codingTest.programmers.lv3.불량사용자;

import java.util.*;

class Solution {
    private Set<Integer> uniqueCombos = new HashSet<>();
    private List<List<Integer>> candidates;
    private String[] banned;
    private int bannedCount;

    public int solution(String[] user_id, String[] banned_id) {
        banned = banned_id;
        bannedCount = banned.length;
        candidates = new ArrayList<>();
        for (String pattern : banned) {
            List<Integer> matchList = new ArrayList<>();
            for (int i = 0; i < user_id.length; i++) {
                if (matches(user_id[i], pattern)) {
                    matchList.add(i);
                }
            }
            candidates.add(matchList);
        }
        dfs(0, 0);
        return uniqueCombos.size();
    }
    
    private void dfs(int idx, int usedMask) {
        if (idx == bannedCount) {
            uniqueCombos.add(usedMask);
            return;
        }
        for (int userIdx : candidates.get(idx)) {
            if ((usedMask & (1 << userIdx)) == 0) {
                dfs(idx + 1, usedMask | (1 << userIdx));
            }
        }
    }
    
    private boolean matches(String user, String pattern) {
        if (user.length() != pattern.length()) {
            return false;
        }
        for (int i = 0; i < user.length(); i++) {
            char pc = pattern.charAt(i), uc = user.charAt(i);
            if (pc != '*' && pc != uc) {
                return false;
            }
        }
        return true;
    }
}
