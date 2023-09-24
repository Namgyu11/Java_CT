package codingTest.preCT_01.preCT_05.ct01;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;


//23 - 09 - 24 풀이 -- 다시 풀어보기

public class Solution {
    public static String solution(String s) {
        String answer = "";
        HashMap<String, Integer> hashMap = new HashMap<>();

        String[] str = s.split("");
        for (String i : str) {
            if (hashMap.containsKey(i)) {
                hashMap.put(i, hashMap.get(i) + 1);
            } else {
                hashMap.put(i, 1);
            }
        }
        int maxCount = 0;

        for (int count : hashMap.values()) {
            if (count > maxCount) {
                maxCount = count;
            }
        }
        TreeSet<String> maxChars = new TreeSet<>();

        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() == maxCount) {
                maxChars.add(entry.getKey());
            }
        }
        answer = maxChars.first();


        return answer;
    }

    public static void main(String[] args) {
        String s = "google";
        System.out.println(solution(s));
    }
}
