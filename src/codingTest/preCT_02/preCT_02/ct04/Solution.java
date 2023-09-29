package codingTest.preCT_02.preCT_02.ct04;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int solution(int[] arr) {
        int answer = 0;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i : arr){
            if(hashMap.containsKey(i)){
                hashMap.put(i, hashMap.get(i) + 1);
            }else {
                hashMap.put(i, 1);
            }
        }

        for(Map.Entry<Integer,Integer> entry : hashMap.entrySet()){
            if(entry.getValue() == 1){
                answer = entry.getKey();
            }
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}
