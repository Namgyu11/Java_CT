package codingTest.programmers.lv2.n진수게임;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder seq = new StringBuilder();
        int num = 0;
        int targetLen = p - 1 + (t - 1) * m + 1;
        while (seq.length() < targetLen) {
            seq.append(toBase(n, num++));
        }
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < t; i++) {
            answer.append(seq.charAt(p - 1 + i * m));
        }
        return answer.toString();
    }
    
    private String toBase(int n, int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        int x = num;
        while (x > 0) {
            int d = x % n;
            char c = d < 10 ? (char)('0' + d) : (char)('A' + (d - 10));
            sb.append(c);
            x /= n;
        }
        return sb.reverse().toString();
    }
}
