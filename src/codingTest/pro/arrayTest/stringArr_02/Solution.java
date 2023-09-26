package codingTest.pro.arrayTest.stringArr_02;

// 프로그래머스 - 코딩테스트 연습 - 코딩테스트 입문 - 문자열안에 문자열
public class Solution {
    public int solution(String str1, String str2) {
        int answer = 2;
        if(str1.contains(str2)){
            answer =1;
        }
        return answer;
    }
}
