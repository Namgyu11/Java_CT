package codingTest.preCT_02.preCT_02.ct02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public static int[] solution(int[] arr) {
        int[] answer = new int[arr.length];
        LinkedList<Integer> list = new LinkedList<>();
        for(int i : arr){
            if(i % 2 == 0){
                list.add(i);
            }else {
                list.add(i);
                list.add(i);
            }
        }
        if(list.size() != arr.length){
            for (int i = 0; i < arr.length; i++) {
                answer[i] = list.get(i);
            }
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}
