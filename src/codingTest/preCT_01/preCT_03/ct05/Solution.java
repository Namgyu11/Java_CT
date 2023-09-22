package codingTest.preCT_01.preCT_03.ct05;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public static String solution(String[] bj, String[] one, String[] two) {
        LinkedList<String> list =new LinkedList<>(Arrays.asList(bj));

        int reward = 0;
        for(String s : one){
            list.remove(s);
            reward += 150;
        }
        for(String s : two){
            list.remove(s);
            reward += 300;
        }

        return String.format("%d만원(%s)",reward+450,list.poll());
    }

    public static void main(String[] args) {
        String[]bj = {"혁준", "하밥", "양상", "심심이", "소스왕"};
        String[]one = {"혁준", "양상"};
        String[]two = {"심심이", "소스왕"};

        System.out.println(solution(bj,one,two));
    }
}
