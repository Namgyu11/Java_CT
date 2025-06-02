package codingTest.CT.preCT_00.ct05.ct05_04;

import java.util.HashMap;

public class Solution {
    public static int solution(String s) {
        int answer = 0;
        String[] str = s.split(" ");
        HashMap<String, Integer> hashMap = new HashMap();
        for (int i = 0; i < str.length; i++) {
            hashMap.put(str[i],1);
        }
        answer = hashMap.size();
        return answer;
    }

    public static void main(String[] args) {
        String s = "Hello world Nice world";
        System.out.println(solution(s));
    }
}
