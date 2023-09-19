package codingTest.preCT_01.preCT_01.ct04;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int solution(String s) {
        int answer = 0;

        HashMap<String,Integer> hashMap = new HashMap<>();

        String[] str = s.split("");
        for (int i = 0; i <str.length; i++) {
            if(hashMap.containsKey(str[i])){
                hashMap.put(str[i],hashMap.get(str[i]) + 1);
            }else {
                hashMap.put(str[i], 1);
            }
        }

        String maxKey = null;
        int maxValue = 0;
        for(Map.Entry<String,Integer> map : hashMap.entrySet()){
            if(map.getValue() > maxValue){
                maxValue = map.getValue();
                maxKey = map.getKey();
            }
        }

        return Integer.valueOf(maxKey);


        /*  스트림
          HashMap<String, Integer> hashMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            hashMap.put(String.valueOf(c), hashMap.getOrDefault(String.valueOf(c), 0) + 1);
        }

        Optional<Map.Entry<String, Integer>> maxEntry = hashMap.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());

        String a =maxEntry.map(Map.Entry::getKey).orElse(null);
        return Integer.valueOf(a);*/
    }

    public static void main(String[] args) {
        String s ="174771177";
        System.out.println(solution(s));
    }

}
