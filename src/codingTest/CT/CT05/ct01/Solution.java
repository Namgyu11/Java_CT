package codingTest.CT.CT05.ct01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Solution {
    public boolean solution1(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        return sMap.equals(tMap);
    }
    public boolean solution(String s, String t) {
        boolean answer = true;
        String[] str1 = s.split("");
        String[] str2 = t.split("");
        if(str1.length == str2.length){
            Arrays.sort(str1);
            Arrays.sort(str2);
        }else {
            return false;
        }

        for (int i = 0; i < str1.length; i++) {
            if(!str1[i].equals(str2[i])){
                return false;
            }
        }
        return answer;
    }

}
