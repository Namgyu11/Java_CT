package inflearn.session02.ct01.백십옮기기;

import java.util.Stack;

class Solution {
    public String[] solution(String[] s) {
        String[] result = new String[s.length];

        for (int i = 0; i < s.length; i++) {
            result[i] = rearrange(s[i]);
        }

        return result;
    }

    private String rearrange(String s) {
        Stack<Character> stack = new Stack<>();
        int count110 = 0;
        
        for (char c : s.toCharArray()) {
            stack.push(c);
            while (stack.size() >= 3) {
                int len = stack.size();
                if (stack.get(len - 3) == '1' && stack.get(len - 2) == '1' && stack.get(len - 1) == '0') {
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    count110++;
                } else {
                    break;
                }
            }
        }
        
        StringBuilder remainBuilder = new StringBuilder();
        for (char ch : stack) {
            remainBuilder.append(ch);
        }
        String remain = remainBuilder.toString();
        
        int pos = remain.lastIndexOf('0');
        StringBuilder answer = new StringBuilder();
        
        if (pos == -1) {
            for (int i = 0; i < count110; i++) {
                answer.append("110");
            }
            answer.append(remain);
        } else {
            answer.append(remain.substring(0, pos + 1));
            for (int i = 0; i < count110; i++) {
                answer.append("110");
            }
            answer.append(remain.substring(pos + 1));
        }
        
        return answer.toString();
    }
}
