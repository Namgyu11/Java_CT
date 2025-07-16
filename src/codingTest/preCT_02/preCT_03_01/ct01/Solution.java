package codingTest.preCT_02.preCT_03_01.ct01;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public static boolean solution(int[] arr) {
        boolean answer = true;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i : arr){
            hashMap.put(i,hashMap.getOrDefault(i,0) + 1);
        }

        HashSet<Integer> set = new HashSet();

        for(Integer value : hashMap.values()){
            if(!set.add(value)){
                return false;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,3,3,3,4,4,4,4};
        System.out.println(solution(arr));
    }
}
