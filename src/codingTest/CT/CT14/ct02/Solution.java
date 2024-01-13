package codingTest.CT.CT14.ct02;

import java.util.*;


//24-01-11 풀이 - 다시 풀기 (스택, 그리디 알고리즘)

public class Solution {
    public String solution(String s, int k) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            while (!stack.isEmpty() && stack.peek() > c && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        for (int i = 0; i < k; i++) {
            stack.pop();
        }

        StringBuilder answer = new StringBuilder();
        while (!stack.isEmpty()) {
            answer.append(stack.pop());
        }

        // 스택은 LIFO 구조이기 때문에 역순으로 되어있음. 따라서 reverse.
        answer.reverse();

        // 앞의 불필요한 0 제거
        while (answer.length() > 1 && answer.charAt(0) == '0') {
            answer.deleteCharAt(0);
        }

        return answer.toString();
    }

    public String solution1(String s, int k) {
        Stack<Character> stack = new Stack<>();

        return null;
    }
}
