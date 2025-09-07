package inflearn.session03.ct05.자동완성;

import java.util.Arrays;

class Solution {
    public long solution(String[] words) {
        int n = words.length;
        Arrays.sort(words);
        long total = 0;
        for (int i = 0; i < n; i++) {
            int maxCommon = 0;
            if (i > 0) {
                maxCommon = Math.max(maxCommon, commonPrefix(words[i], words[i - 1]));
            }
            if (i < n - 1) {
                maxCommon = Math.max(maxCommon, commonPrefix(words[i], words[i + 1]));
            }
            total += Math.min(words[i].length(), maxCommon + 1);
        }
        return total;
    }

    private int commonPrefix(String a, String b) {
        int len = Math.min(a.length(), b.length());
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) == b.charAt(i)) {
                cnt++;
            } else {
                break;
            }
        }
        return cnt;
    }
}
