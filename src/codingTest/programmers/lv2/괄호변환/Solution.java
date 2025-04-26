package codingTest.programmers.lv2.괄호변환;

class Solution {
    public String solution(String p) {
        return transform(p);
    }
    
    private String transform(String w) {
        if (w.isEmpty()) {
            return "";
        }
        int balance = 0;
        int idx = 0;
        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance == 0) {
                idx = i;
                break;
            }
        }
        String u = w.substring(0, idx + 1);
        String v = w.substring(idx + 1);
        if (isCorrect(u)) {
            return u + transform(v);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('(');
            sb.append(transform(v));
            sb.append(')');
            sb.append(flip(u.substring(1, u.length() - 1)));
            return sb.toString();
        }
    }
    
    private boolean isCorrect(String s) {
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                cnt++;
            } else {
                if (cnt == 0) {
                    return false;
                }
                cnt--;
            }
        }
        return cnt == 0;
    }
    
    private String flip(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c == '(' ? ')' : '(');
        }
        return sb.toString();
    }
}
