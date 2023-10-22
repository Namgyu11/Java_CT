package codingTest.CT.CT02.ct03;

import java.util.Stack;

//23-10-22(풀이) - 다시 풀기
public class Solution {
    public static String solution(String code) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder curString = new StringBuilder();
        int k = 0;

        while (k < code.length()) {
            char ch = code.charAt(k);
            if (Character.isDigit(ch)) {
                int digitStart = k;
                while (Character.isDigit(code.charAt(k + 1))) {
                    k++;
                }
                countStack.push(Integer.parseInt(code.substring(digitStart, k + 1)));
            } else if (ch == '{') {
                stringStack.push(curString);
                curString = new StringBuilder();
            } else if (ch == '}') {
                StringBuilder decodedString = stringStack.pop();
                for (int i = countStack.pop(); i > 0; i--) {
                    decodedString.append(curString);
                }
                curString = decodedString;
            } else {
                curString.append(ch);
            }

            k++;
        }

        return curString.toString();
    }

    public static void main(String[] args) {

        String c = "5{he2{l}o}friend";

        System.out.println(solution(c));
    }
}
