package codingTest.preCT_02.preCT_01.ct04;

import java.util.HashMap;

public class Solution {
    public int solution(String s) {
        int answer = 0;
        HashMap<String, Integer> hashMap = new HashMap<>();
        String[] str = s.split(" ");
        for(String i : str){
            hashMap.put(i,1);
        }
        answer = hashMap.size();
        return answer;
    }
}
