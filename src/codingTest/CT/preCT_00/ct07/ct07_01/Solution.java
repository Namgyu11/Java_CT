package codingTest.CT.preCT_00.ct07.ct07_01;

import java.util.HashMap;

public class Solution {
    public static String solution(String s) {
        String answer = "";
        String[] str = s.split("");
        String tempStr = "";
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i <str.length; i++) {
            if(hashMap.containsKey(str[i])){
                int temp = hashMap.get(str[i]) + 1;
                hashMap.put(String.valueOf(str[i]), temp);
            }else {
                hashMap.put(String.valueOf(str[i]),1);
            }
        }
        while (!hashMap.isEmpty()) {
            String maxKey = null;
            for (String key : hashMap.keySet()) {
                if (maxKey == null || hashMap.get(key) > hashMap.get(maxKey)) {
                    maxKey = key;
                }
            }
            if(hashMap.size() == 1){
                tempStr += maxKey;
            }else {
                tempStr += maxKey + " ";
            }

            hashMap.remove(maxKey);
        }

        for (int i = 0; i < 10 ; i++) {
            if(!tempStr.contains(String.valueOf(i))) {
                tempStr = tempStr + " " + i ;
            }
        }
        System.out.println(tempStr);


        return tempStr;
    }

    public static void main(String[] args) {
        String s ="221123";
        System.out.println(solution(s));
    }
}
