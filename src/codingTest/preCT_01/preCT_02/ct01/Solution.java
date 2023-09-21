package codingTest.preCT_01.preCT_02.ct01;

import java.util.LinkedList;

public class Solution {
    public static String solution(int n, String s, int t) {
        String answer = "";
        String[] str = s.split("");
        LinkedList<String> list = new LinkedList();
        int count = 0;

        for (int i = 0; i < n; i++) {
            list.offer(".");
        }
        for (int i = 0; i < str.length; i++) {
            list.offer(str[i]);
        }

        while (true){
            if(count == t){
                for (int i = 0; i < n; i++) {
                    answer+=list.pollFirst();
                }
                break;
            }
            String temp = list.pollFirst();
            list.offerLast(temp);
            count++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 5;
        String s = "Snowball";
        int t = 18;
        System.out.println(solution(n,s,t));
    }
}
