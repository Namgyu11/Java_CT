package codingTest.pro.hashTest.onceChar;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;

// 프로그래머스 - 해시테이블
// 코딩테스트 연습 -코딩테스트 입문 - 한 번만 등장한 문자
public class Solution {
    public static String solution(String s) {
        String answer = "";
        Hashtable<String,Integer> hashtable = new Hashtable<>();
        String[] str = s.split("");

        for(String i : str){
            if(hashtable.containsKey(i)){
                hashtable.put(i, hashtable.get(i) + 1);
            }else {
                hashtable.put(i, 1);
            }
        }

        for(Map.Entry<String,Integer> entry : hashtable.entrySet()){
            if (entry.getValue() == 1){
                answer += entry.getKey();
            }
        }

        char[]c = answer.toCharArray();

        Arrays.sort(c);

        answer = new String(c);

        return answer;
    }

    public static void main(String[] args) {
        String s = "hello";
        System.out.println(solution(s));
    }
}
