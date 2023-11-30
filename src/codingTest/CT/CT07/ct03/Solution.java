package codingTest.CT.CT07.ct03;


import java.util.*;
//23-11-24(풀이)  - @@다시 풀어보기@@ - 백트래킹

class Solution {
    List<String> results = new ArrayList<>();

    public String[] solution(String s) {
        backtrack(s, 0, new ArrayList<>());
        return results.toArray(new String[0]);
    }

    private void backtrack(String s, int idx, List<String> current) {
        // 이미 4개의 세그먼트를 가지고 있고, 문자열의 모든 문자를 사용한 경우

        if (current.size() == 4 && idx == s.length()) {
            results.add(String.join(".", current));
            return;
        }
        // 이미 4개의 세그먼트를 가지고 있지만 아직 문자를 남겨두었거나,
        // 모든 문자를 사용했지만 아직 4개의 세그먼트를 가지지 않은 경우
        if (current.size() == 4 || idx == s.length()) {
            return;
        }

        for (int end = idx; end < s.length(); end++) {
            if (end - idx > 2) break; // 세그먼트가 너무 길어짐


            String segment = s.substring(idx, end + 1);
            int val = Integer.parseInt(segment);
            // 세그먼트가 0으로 시작하고 0이 아니거나, 255보다 큰 경우 무시
            if ((segment.startsWith("0") && segment.length() > 1) || val > 255) continue;

            current.add(segment);
            backtrack(s, end + 1, current);
            current.remove(current.size() - 1); // 백트래킹
        }
    }
}

