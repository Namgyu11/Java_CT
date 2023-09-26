package codingTest.preCT_00.ct06.ct06_04;

import java.util.*;

public class Solution {
    public static int solution(int[] arr) {
        int answer = 0;

        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for (int i = 0; i <arr.length ; i++) {
            if(hashMap.containsKey(arr[i])){
                int temp = hashMap.get(arr[i])+1;
                hashMap.put(arr[i],temp);
            }else {
                hashMap.put(arr[i],1);
            }
        }
        Map.Entry<Integer,Integer> min = null;
        for(Map.Entry<Integer,Integer> entry : hashMap.entrySet()){
            if(entry.getValue() == 1){
                min = entry;
                answer = min.getKey();
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        hashMap.put(1,1);
        hashMap.put(2,1);
        hashMap.put(3,1);
        hashMap.put(1,1);
        System.out.println(hashMap);

    }

}
