package codingTest.preCT_03.preCT_03_01.preCT_03_02.preCT_03_03.preCT_03_04.ct03.가장긴팰린드롬;

class Solution {
    public int solution(String s) {
        int maxLen = 0;
        int len = s.length();

        for (int i = 0; i < len; i++) {
            maxLen = Math.max(maxLen, expand(s, i, i));  
            maxLen = Math.max(maxLen, expand(s, i, i + 1)); 
        }

        return maxLen;
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; 
    }
}
