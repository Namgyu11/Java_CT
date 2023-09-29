package codingTest.preCT_02.preCT_03.ct01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//23 - 09 - 29 (풀이) - 다시 풀기
public class Solution {
    public static String solution(String s) {
        String answer = "";
        int count = 0;
        String[] str = s.split("");
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i <=9; i++) {
            hashMap.put(String.valueOf(i), 1);
        }
        for(String i : str){
            if(hashMap.containsKey(i)){
                hashMap.put(i,hashMap.get(i) + 1);
            }
        }
        List<Map.Entry<String,Integer>> list = new ArrayList<>(hashMap.entrySet());
        list.sort(Map.Entry.<String,Integer>comparingByValue().reversed());
        for (Map.Entry<String,Integer> entry : list){
            if(count == 9){
                answer += entry.getKey();

            }else {
                answer += entry.getKey() + " ";
            }
            count++;
        }
        return answer;
    }

    public static void main(String[] args) {
        String s = "221123";
        System.out.println(solution(s));
    }
}
