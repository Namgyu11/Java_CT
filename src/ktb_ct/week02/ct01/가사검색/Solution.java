package ktb_ct.week02.ct01.가사검색;

import java.util.HashMap;
import java.util.Map;

class Solution {
    static class Trie {
        int count;
        Trie[] next = new Trie[26];
    }
    
    public int[] solution(String[] words, String[] queries) {
        Map<Integer, Trie> pref = new HashMap<>(), suf = new HashMap<>();
        for (String w : words) {
            int L = w.length();
            Trie pRoot = pref.computeIfAbsent(L, k -> new Trie());
            Trie sRoot = suf.computeIfAbsent(L, k -> new Trie());
            pRoot.count++;
            Trie node = pRoot;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (node.next[i] == null) {
                    node.next[i] = new Trie();
                }
                node = node.next[i];
                node.count++;
            }
            sRoot.count++;
            node = sRoot;
            for (int i = L - 1; i >= 0; i--) {
                int idx = w.charAt(i) - 'a';
                if (node.next[idx] == null) {
                    node.next[idx] = new Trie();
                }
                node = node.next[idx];
                node.count++;
            }
        }
        
        int[] answer = new int[queries.length];
        for (int qi = 0; qi < queries.length; qi++) {
            String q = queries[qi];
            int L = q.length();
            Trie root;
            if (!pref.containsKey(L)) {
                answer[qi] = 0;
                continue;
            }
            if (q.charAt(0) == '?') {
                root = suf.get(L);
                int idxEnd = q.lastIndexOf('?') + 1;
                for (int i = L - 1; i >= idxEnd; i--) {
                    int idx = q.charAt(i) - 'a';
                    if (root.next[idx] == null) {
                        root = null;
                        break;
                    }
                    root = root.next[idx];
                }
                answer[qi] = (root == null ? 0 : root.count);
            } else {
                root = pref.get(L);
                int idxStart = q.indexOf('?');
                for (int i = 0; i < idxStart; i++) {
                    int idx = q.charAt(i) - 'a';
                    if (root.next[idx] == null) {
                        root = null;
                        break;
                    }
                    root = root.next[idx];
                }
                answer[qi] = (root == null ? 0 : root.count);
            }
        }
        return answer;
    }
}
