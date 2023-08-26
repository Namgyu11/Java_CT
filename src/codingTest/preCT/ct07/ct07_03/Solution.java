package codingTest.preCT.ct07.ct07_03;

import java.util.Stack;

public class Solution {
    public static double solution(String S) {
        double answer = 0;
        return answer;
    }
    public static int evaluate(String expression) {
        char[] arr = expression.toCharArray();
        Stack<Integer> stack = new Stack<>();

        int num = 0;
        char prevOp = '+';

        for (int i = 0; i < arr.length; i++) {
            if (Character.isDigit(arr[i])) {
                num = num * 10 + (arr[i] - '0');
            }

            if (!Character.isDigit(arr[i]) || i == arr.length - 1) {
                switch(prevOp) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }

                prevOp = arr[i];
                num = 0;
            }
        }

        int result = 0;

        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
    public static void main(String[] args) {
        String s = "6+3*16/2";

        System.out.println(evaluate(s));

    }
}
