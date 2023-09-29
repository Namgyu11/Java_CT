package codingTest.preCT_00.ct07.ct07_03;

import java.util.Stack;

public class Solution {
    public static double solution(String S) {
        double answer = 0;
        return answer;
    }
    public static double evaluate(String expression) {
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

        double result = 0;

        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    public static double as (String S){
        // 공백 제거
        S = S.replaceAll("\\s+", "");

        // 현재 숫자와 연산자를 저장할 변수 초기화
        double currentNumber = 0;
        char currentOperator = '+';

        // 결과값을 저장할 변수 초기화
        double answer = 0;

        // 문자열 순회
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            if (Character.isDigit(c)) {
                // 현재 문자가 숫자인 경우, 현재 숫자에 자릿수 추가
                currentNumber = currentNumber * 10 + (c - '0');
            }

            if (!Character.isDigit(c) || i == S.length() - 1) {
                // 현재 문자가 연산자이거나 마지막 문자인 경우, 이전까지의 숫자와 연산자로 계산 수행
                switch (currentOperator) {
                    case '+':
                        answer += currentNumber;
                        break;
                    case '-':
                        answer -= currentNumber;
                        break;
                    case '*':
                        answer *= currentNumber;
                        break;
                    case '/':
                        answer /= currentNumber;
                        break;
                }

                // 다음 연산을 위해 변수 초기화
                currentNumber = 0;

                if (c == '+' || c == '-' || c == '*' || c == '/') {
                    // 현재 문자가 연산자인 경우, 다음 연산에 사용하기 위해 저장
                    currentOperator = c;
                }
            }
        }

        // 소수점 둘째 자리까지 반올림하여 반환
        return Math.round(answer * 100.0) / 100.0;
    }

    public static void main(String[] args) {
        String s = "2*3+5/6*3+15";

        System.out.println(as(s));

    }
}
