package codingTest.preCT.ct05.ct05_03;

import java.util.Stack;

public class Solution {
    public static boolean solution(String p, String s) {
        boolean answer = true;
        String[] str1 = p.split("");
        String[] str2 = s.split(" ");
        int size1 = 0;
        int size2 = 0;
        Stack stack = new Stack<>();
        for (int i = 0; i <str1.length ; i++) {
            if(stack.contains(str1[i])){
                size1 = stack.size();
                break;
            }
            stack.push(str1[i]);

        }
        stack.clear();
        for(int i = 0; i < str2.length; i++){
            if(stack.contains(str2[i])){
                size2 = stack.size();
                break;
            }
            stack.push(str2[i]);
        }
        if(size1 == size2){
            answer = true;
        }else {
            answer = false;
        }
        return answer;
    }

    public static void main(String[] args) {
        String p = "갸가갸가";
        String s = "금도끼 은도끼 금도끼 은도끼";

        System.out.println(solution(p,s));
    }
}
