package codingTest.programmers.lv2.문자열압축;

class Solution {
    public int solution(String s) {
        int n = s.length();
        if (n == 1) {
            return 1;
        }
        int answer = n;
        for (int step = 1; step <= n / 2; step++) {
            int compressedLen = 0;
            String prev = s.substring(0, step);
            int count = 1;
            int i = step;
            for (; i + step <= n; i += step) {
                String curr = s.substring(i, i + step);
                if (curr.equals(prev)) {
                    count++;
                } else {
                    if (count > 1) {
                        compressedLen += Integer.toString(count).length();
                    }
                    compressedLen += prev.length();
                    prev = curr;
                    count = 1;
                }
            }
            if (count > 1) {
                compressedLen += Integer.toString(count).length();
            }
            compressedLen += prev.length();
            int remain = n - i;
            compressedLen += remain;
            answer = Math.min(answer, compressedLen);
        }
        return answer;
    }
}
