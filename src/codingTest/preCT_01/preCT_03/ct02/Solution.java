package codingTest.preCT_01.preCT_03.ct02;


import java.util.HashMap;
import java.util.Stack;

//다시 풀어 보기
public class Solution {
    public static int solution(String S) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> hashMap = new HashMap<>();

        hashMap.put(')', '(');
        hashMap.put('}', '{');
        hashMap.put(']', '[');
        hashMap.put('>', '<');

        for(char c : S.toCharArray()){
            if(hashMap.containsValue(c)){
                stack.push(c);
            }else if(stack.isEmpty() || stack.pop() != hashMap.get(c)){
                return 0;
            }
        }

        return stack.isEmpty()? 1:0;
    }

    public static void main(String[] args) {
        String s1 = "(()){[<>]}";
        System.out.println(solution(s1)); // Output: 1

        String s2 = "({)}[<]>";
        System.out.println(solution(s2)); // Output: 0
    }
}
