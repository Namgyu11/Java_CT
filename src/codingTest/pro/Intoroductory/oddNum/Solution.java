package codingTest.pro.Intoroductory.oddNum;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
프로그래머스 -코딩테스트 연습- 코딩테스트 입문 -짝수는 싫어요
* */
public class Solution {
    public static int[] solution(int n){
        return IntStream.rangeClosed(0,n).filter(v -> v % 2 == 1).toArray();
    }

    public static void main(String[] args) {
        int n = 10;

        System.out.println(Arrays.toString(solution(n)));
    }
}
