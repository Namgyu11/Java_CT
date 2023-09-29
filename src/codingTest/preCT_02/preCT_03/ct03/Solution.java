package codingTest.preCT_02.preCT_03.ct03;

import java.util.*;
import java.text.DecimalFormat;

// 23-09-23(풀이) - 다시 풀어보기
class Solution {
    public static String solution(String S) {
        // 연산자 우선순위 맵
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('+', 1);
        hashMap.put('-', 1);
        hashMap.put('*', 2);
        hashMap.put('/', 2);

        Stack<Character> stack = new Stack<>();
        ArrayList<String> list = new ArrayList<>();

        int i = 0;

        while (i < S.length()) {
            char ch = S.charAt(i);

            if (Character.isDigit(ch)) {
                StringBuilder number = new StringBuilder();

                while (i < S.length() && Character.isDigit(S.charAt(i))) {
                    number.append(S.charAt(i++));
                }

                list.add(number.toString());
            }else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                while (!stack.isEmpty() && hashMap.get(stack.peek()) >= hashMap.get(ch)){
                    list.add(String.valueOf(stack.pop()));
                }
                stack.push(ch);
                i++;
            }
        }
        while (!stack.isEmpty()){
            list.add(String.valueOf(stack.pop()));
        }
        Stack<Double> evalStack = new Stack<>();
        for(String str : list){
            switch (str){
                case "+":
                    evalStack.push(evalStack.pop() + evalStack.pop());
                    break;
                case "-":
                    double sub = evalStack.pop();
                    double min = evalStack.pop();
                    evalStack.push(min- sub);
                    break;
                case"*":
                    evalStack.push(evalStack.pop() * evalStack.pop());
                    break;
                case"/":
                    double div = evalStack.pop();
                    double dividend = evalStack.pop();

                    if(div != 0){
                        evalStack.push(dividend/div);
                    }
                    break;
                default:
                    evalStack.push(Double.parseDouble(str));
            }
        }
        DecimalFormat df=new DecimalFormat("0.00");

        return df.format(evalStack.pop());
    }

    public static void main(String[] args) {
        String s = "2*3+5/6*3+15";
        System.out.println(solution(s));
    }
}

