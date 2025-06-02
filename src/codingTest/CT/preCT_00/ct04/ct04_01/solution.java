package codingTest.CT.preCT_00.ct04.ct04_01;

import java.util.*;

public class solution {
    public static String solution(String s) {
        String answer = "";
        int count = 1;
        String[] str = s.split("");
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < str.length; i++) {
            if (!treeMap.containsKey(str[i])) {
                treeMap.put(str[i], count);
            } else {
                int temp = treeMap.get(str[i]) + 1;
                treeMap.put(str[i], temp);
            }
        }
        String maxKey ="";
        int maxCount = 0;

        for(Map.Entry<String, Integer> entry : treeMap.entrySet()){
            if(entry.getValue() > maxCount){
                maxCount = entry.getValue();;
                maxKey = entry.getKey();
            }
        }
        answer =maxKey;

        return answer;
    }

    public static void main(String[] args) {

        String a = "google";
        System.out.println(solution(a));

    }
}
